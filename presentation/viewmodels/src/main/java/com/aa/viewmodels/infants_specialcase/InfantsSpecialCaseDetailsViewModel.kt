package com.aa.viewmodels.infants_specialcase

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.usecase.infants.GetAllInfantsSpecialCaseByIdUseCase
import com.aa.viewmodels.specialcase.SpecialCaseDetailsArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class InfantsSpecialCaseDetailsViewModel@Inject constructor(
    private val getAllInfantsSpecialCaseByIdUseCase: GetAllInfantsSpecialCaseByIdUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<InfantsSpecialCaseDetailsUiState>(InfantsSpecialCaseDetailsUiState()){

    private val args: SpecialCaseDetailsArgs = SpecialCaseDetailsArgs(savedStateHandle)

    init {
        getSpecialCaseDetails()
    }
    private fun getSpecialCaseDetails(){
        val id = args.id.toInt()
        tryToExecute(
            { getAllInfantsSpecialCaseByIdUseCase(id) },
            ::onGetSpecialCaseDetailsSuccess,
            ::onError
        )
    }

    private fun onGetSpecialCaseDetailsSuccess(special: InfantsSpecialCaseEntity){
        _state.update {
            it.copy(
                isLoading = false,
                specialCase = special.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}