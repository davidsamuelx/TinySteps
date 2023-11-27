package com.aa.viewmodels.infant_home_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.models.infants.InfantsRelationEntity
import com.aa.usecase.infants.GetAllGuidanceUseCase
import com.aa.usecase.infants.GetAllInfantsRelationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeInfantViewModel @Inject constructor(
    private val getAllGuidanceUseCase: GetAllGuidanceUseCase,
    private val getAllInfantsRelationUseCase: GetAllInfantsRelationUseCase
): BaseViewModel<HomeInfantUiState>(HomeInfantUiState()) {

    init {
        getAllGuidance()
        getAllRelation()
    }


    private fun getAllRelation(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllInfantsRelationUseCase() },
            ::onGetRelationsSuccess,
            ::onError
        )
    }

    private fun getAllGuidance(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllGuidanceUseCase() },
            ::onGetGuidanceSuccess,
            ::onError
        )
    }

    private fun onGetGuidanceSuccess(allGuidance: List<GuidanceInstructionEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                guidanceList = allGuidance.map {
                    allGuidanceEntity -> allGuidanceEntity.toUiState()
                }
            )
        }
    }

    private fun onGetRelationsSuccess(allRelations: List<InfantsRelationEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                relationList = allRelations.map {
                    allRelations -> allRelations.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}