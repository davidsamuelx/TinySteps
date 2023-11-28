package com.aa.viewmodels.infants_sleep_position

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsSleepEntity
import com.aa.usecase.infants.SelectInfantsSleepUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InfantsSleepHoursDetailsViewModel@Inject constructor(
    private val selectInfantsSleepUseCase: SelectInfantsSleepUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<InfantsSleepDetailsUiState>(InfantsSleepDetailsUiState()) {

    private val args: InfantsSleepDetailsArgs = InfantsSleepDetailsArgs(savedStateHandle)

    init {
        getSleepBYId()
    }

    private fun getSleepBYId(){
        val id = args.id.toInt()
        tryToExecute(
            {selectInfantsSleepUseCase(id)},
            ::onGetSleepHoursByIdSuccess,
            ::onError
        )
    }
    private fun onGetSleepHoursByIdSuccess(sleep: InfantsSleepEntity){
        _state.update {
            it.copy(
                isLoading = false,
                infantsSleep = sleep.toDetailUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}