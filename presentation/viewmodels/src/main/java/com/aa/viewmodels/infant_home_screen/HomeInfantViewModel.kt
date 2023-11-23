package com.aa.viewmodels.infant_home_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.usecase.infants.GetAllGuidanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeInfantViewModel @Inject constructor(
    private val getAllGuidanceUseCase: GetAllGuidanceUseCase,
): BaseViewModel<HomeInfantUiState>(HomeInfantUiState()) {

    init {
        getAllGuidance()
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

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}