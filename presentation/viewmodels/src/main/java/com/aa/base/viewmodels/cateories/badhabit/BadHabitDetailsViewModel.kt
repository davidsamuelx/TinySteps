package com.aa.base.viewmodels.cateories.badhabit

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.BadHabitEntity
import com.aa.usecase.GetBadHabitByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BadHabitDetailsViewModel @Inject constructor(
    private val getBadHabitByIdUseCase: GetBadHabitByIdUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<BadHabitDetailsUiState>(BadHabitDetailsUiState()){

    private val args: BadHabitDetailsArgs = BadHabitDetailsArgs(savedStateHandle)

    init {
        getBadHabitById()
    }


    private fun getBadHabitById(){
        val id = args.id.toInt()
        tryToExecute(
            {getBadHabitByIdUseCase(id)},
            ::onGetBadHabitByIdSuccess,
            ::onError
        )
    }


    private fun onGetBadHabitByIdSuccess(badHabit: BadHabitEntity){
        _state.update {
            it.copy(
                isLoading = false,
                badHabit = badHabit.toDetailsUiState()
            )
        }
    }


    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }


}