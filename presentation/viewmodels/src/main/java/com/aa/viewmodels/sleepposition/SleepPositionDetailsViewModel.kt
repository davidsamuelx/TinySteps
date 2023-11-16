package com.aa.viewmodels.sleepposition

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.SleepPositionEntity
import com.aa.usecase.kids.GetSleepPositionByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SleepPositionDetailsViewModel@Inject constructor(
    private val getSleepPositionByIdUseCase: GetSleepPositionByIdUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<SleepPositionDetailsUiState>(SleepPositionDetailsUiState()) {

    private val args: SleepDetailsArgs = SleepDetailsArgs(savedStateHandle)

    init {
        getSleepBYId()
    }

    private fun getSleepBYId(){
        val id = args.id.toInt()
        tryToExecute(
            {getSleepPositionByIdUseCase(id)},
            ::onGetSleepPositionByIdSuccess,
            ::onError
        )
    }

    private fun onGetSleepPositionByIdSuccess(sleep: SleepPositionEntity){
        _state.update {
            it.copy(
                isLoading = false,
                sleepPosition = sleep.toDetailUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}