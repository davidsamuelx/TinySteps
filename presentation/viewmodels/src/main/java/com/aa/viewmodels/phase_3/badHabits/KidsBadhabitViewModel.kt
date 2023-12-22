package com.aa.viewmodels.phase_3.badHabits

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.KidsBadHabitEntity
import com.aa.usecase.kids.GetAllKidsBadHabitsUseCase
import com.aa.usecase.kids.SearchKidsBadHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class KidsBadhabitViewModel @Inject constructor(
    private val getAllKidsBadHabitsUseCase: GetAllKidsBadHabitsUseCase,
    private val searchKidsBadHabitsUseCase: SearchKidsBadHabitsUseCase
) : BaseViewModel<KidsBadHabitUIState>(KidsBadHabitUIState()){

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
                { searchKidsBadHabitsUseCase(currentQuery) },
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
            { getAllKidsBadHabitsUseCase() },
            ::onGetBadHabitsSuccess,
            ::onError
        )
    }
    private fun onGetBadHabitsSuccess(badHabits: List<KidsBadHabitEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                badHabitsList = badHabits.map {
                        badHabitEntity -> badHabitEntity.toUiState()
                }) }
    }
    private fun onBadHabitSearchSuccess(searchResults: List<KidsBadHabitEntity>) {
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