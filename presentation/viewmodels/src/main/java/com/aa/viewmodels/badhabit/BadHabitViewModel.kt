package com.aa.viewmodels.badhabit

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.BadHabitEntity
import com.aa.usecase.GetAllBadHabitsUseCase
import com.aa.usecase.SearchBadHabitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BadHabitViewModel @Inject constructor(
    private val getAllBadHabits: GetAllBadHabitsUseCase,
    private val searchBadHabitUseCase: SearchBadHabitUseCase
) : BaseViewModel<BadHabitUIState>(BadHabitUIState()){

    private var searchJob: Job? = null

    init {
        getBadHabits()
    }

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onBadHabitSearchClicked()
        }
    }

    fun onBadHabitSearchClicked() {
        val currentQuery = _state.value.query
        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchBadHabitUseCase(currentQuery) },
                ::onBadHabitSearchSuccess,
                ::onError
            )
        }else {
            getBadHabits()
        }
    }

    private fun getBadHabits(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllBadHabits() },
            ::onGetBadHabitsSuccess,
            ::onError
        )
    }

    private fun onGetBadHabitsSuccess(badHabits: List<BadHabitEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                badHabitsList = badHabits.map {
                    badHabitEntity -> badHabitEntity.toUiState()
                }) }
    }


    private fun onBadHabitSearchSuccess(searchResults: List<BadHabitEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                badHabitsList = searchResults.map { searchBadHabitEntity ->
                    searchBadHabitEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}