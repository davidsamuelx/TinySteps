package com.aa.viewmodels.sleepposition

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.SleepPositionEntity
import com.aa.usecase.GetAllSleepPositionUseCase
import com.aa.usecase.SearchSleepPositionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SleepPositionViewModel @Inject constructor(
    private val getAllSleepPosition: GetAllSleepPositionUseCase,
    private val searchSleepPositionUseCase: SearchSleepPositionUseCase
): BaseViewModel<SleepPositionUiState>(SleepPositionUiState()) {

    private var searchJob: Job? = null

    init {
        getSleepPosition()
    }

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onSleepPositionSearchClicked()
        }
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

    fun onSleepPositionSearchClicked(){
        val currentQuery = _state.value.query

        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchSleepPositionUseCase(currentQuery) },
                ::onSleepPositionSearchSuccess,
                ::onError
            )
        }else {
            getSleepPosition()
        }
    }

    private fun onSleepPositionSearchSuccess(searchResults: List<SleepPositionEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                sleepPositionList = searchResults.map { searchSleepPositionEntity ->
                    searchSleepPositionEntity.toUiState()
                }
            )
        }
    }


    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}