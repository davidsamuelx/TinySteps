package com.aa.base.viewmodels.cateories.badhabit

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.BadHabitEntity
import com.aa.usecase.GetAllBadHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BadHabitViewModel @Inject constructor(
    private val getAllBadHabits: GetAllBadHabitsUseCase
) : BaseViewModel<BadHabitUIState>(BadHabitUIState()){

    init {
        getBadHabits()
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

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}