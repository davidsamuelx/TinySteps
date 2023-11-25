package com.aa.viewmodels.infants_sleep_position

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsSleepEntity
import com.aa.usecase.infants.GetAllInfantsSleepUseCase
import com.aa.usecase.infants.searchForInfantsSleepUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfantsSleepViewModel  @Inject constructor(
    private val getAllInfantsSleepUseCase: GetAllInfantsSleepUseCase,
    private val searchForInfantsSleepUseCase: searchForInfantsSleepUseCase
): BaseViewModel<InfantsSleepUiState>(InfantsSleepUiState()) {

    private var searchJob: Job? = null

    init {
        getSleepHours()
    }
    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onSleepHoursSearchClicked()
        }
    }

    private fun getSleepHours(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllInfantsSleepUseCase() },
            ::onGetSleepHoursSuccess,
            ::onError
        )
    }
    private fun onGetSleepHoursSuccess(sleepHours: List<InfantsSleepEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                sleepHoursList = sleepHours.map {
                        sleepHours -> sleepHours.toUiState()
                })
        }
    }
    fun onSleepHoursSearchClicked(){
        val currentQuery = _state.value.query

        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchForInfantsSleepUseCase(currentQuery) },
                ::onSleepHoursSearchSuccess,
                ::onError
            )
        }else {
            getSleepHours()
        }
    }
    private fun onSleepHoursSearchSuccess(searchResults: List<InfantsSleepEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                sleepHoursList = searchResults.map { sleepHours ->
                    sleepHours.toUiState()
                }
            )
        }
    }


    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}