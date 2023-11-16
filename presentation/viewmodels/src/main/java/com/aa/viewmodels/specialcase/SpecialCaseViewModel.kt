package com.aa.viewmodels.specialcase

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.SpecialCaseEntity
import com.aa.usecase.GetAllSpecialCasesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SpecialCaseViewModel @Inject constructor(
    private val getAllSpecialCases: GetAllSpecialCasesUseCase
): BaseViewModel<SpecialCaseUIState>(SpecialCaseUIState()){

    init {
        getSpecialCases()
    }


    private fun getSpecialCases(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            {getAllSpecialCases()},
            ::onGetSpecialCaseSuccess,
            ::onError
        )
    }

    private fun onGetSpecialCaseSuccess(specialCase: List<SpecialCaseEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                specialCasesList = specialCase.map {
                    specialCaseEntity -> specialCaseEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}