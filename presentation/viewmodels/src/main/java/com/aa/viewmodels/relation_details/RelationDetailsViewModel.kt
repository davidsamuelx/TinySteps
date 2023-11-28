package com.aa.viewmodels.relation_details

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsRelationEntity
import com.aa.usecase.infants.GetAllInfantsRelationByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RelationDetailsViewModel@Inject constructor(
    private val getAllInfantsRelationByIdUseCase: GetAllInfantsRelationByIdUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<RelationDetailsUiState>(RelationDetailsUiState()) {

    private val args: RelationDetailsArgs = RelationDetailsArgs(savedStateHandle)

    init {
        getRelationById()
    }

    private fun getRelationById(){
        val id = args.id.toInt()
        tryToExecute(
            { getAllInfantsRelationByIdUseCase(id) },
            ::onGetRelationByIdSuccess,
            ::onError
        )
    }

    private fun onGetRelationByIdSuccess(relation: InfantsRelationEntity){
        _state.update {
            it.copy(
                isLoading = false,
                relation = relation.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}