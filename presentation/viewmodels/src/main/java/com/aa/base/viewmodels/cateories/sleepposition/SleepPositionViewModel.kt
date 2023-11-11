package com.aa.base.viewmodels.cateories.sleepposition

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.SleepPositionEntity
import com.aa.usecase.GetAllSleepPositionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SleepPositionViewModel @Inject constructor(
    private val getAllSleepPosition: GetAllSleepPositionUseCase
): BaseViewModel<SleepPositionUiState>(SleepPositionUiState()) {

    init {
        getSleepPosition()
    }


    private fun getSleepPosition(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllSleepPosition() },
            ::onGetSleepPositionSuccess,
            ::onError
        )
    }

    private fun onGetSleepPositionSuccess(sleepPosition: List<SleepPositionEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                sleepPositionList = sleepPosition.map {
                    sleepPositionEntity -> sleepPositionEntity.toUiState()
                })
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}