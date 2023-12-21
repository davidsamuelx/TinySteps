package com.aa.viewmodels.phase_3.badHabits

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.KidsBadHabitEntity
import com.aa.usecase.kids.SelectKidsBadHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class KidsBadhabitsDetailsViewModel @Inject constructor(
    private val selectKidsBadHabitsUseCase: SelectKidsBadHabitsUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<KidsBadHabitDetailsUiState>(KidsBadHabitDetailsUiState()){

    private val args: KidsBadHabitDetailsArgs = KidsBadHabitDetailsArgs(savedStateHandle)

    init {
        getBadHabitById()
    }
    private fun getBadHabitById(){
        val id = args.id
        tryToExecute(
            {selectKidsBadHabitsUseCase(id)},
            ::onGetBadHabitByIdSuccess,
            ::onError
        )
    }


    private fun onGetBadHabitByIdSuccess(badHabit: KidsBadHabitEntity){
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