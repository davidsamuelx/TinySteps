package com.aa.viewmodels.infants_badhabits

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.usecase.infants.GetAllInfnatsBadHabitsUseCase
import com.aa.usecase.infants.SearchInfantsBadHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class InfantsBadhabitViewModel @Inject constructor(
    private val getAllInfantsBadHabitsUseCase: GetAllInfnatsBadHabitsUseCase,
    private val searchInfantsBadHabitUseCase: SearchInfantsBadHabitsUseCase
) : BaseViewModel<InfantsBadHabitUIState>(InfantsBadHabitUIState()){

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
                { searchInfantsBadHabitUseCase(currentQuery) },
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
            { getAllInfantsBadHabitsUseCase() },
            ::onGetBadHabitsSuccess,
            ::onError
        )
    }
    private fun onGetBadHabitsSuccess(badHabits: List<InfantsBadHabitsEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                badHabitsList = badHabits.map {
                        badHabitEntity -> badHabitEntity.toUiState()
                }) }
    }
    private fun onBadHabitSearchSuccess(searchResults: List<InfantsBadHabitsEntity>) {
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