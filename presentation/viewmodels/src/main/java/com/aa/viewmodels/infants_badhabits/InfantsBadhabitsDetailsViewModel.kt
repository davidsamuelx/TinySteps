package com.aa.viewmodels.infants_badhabits

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.usecase.infants.GetAllInfanatsBadHabitsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InfantsBadhabitsDetailsViewModel @Inject constructor(
    private val getInfantsBadHabitByIdUseCase: GetAllInfanatsBadHabitsByIdUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<InfantsBadHabitDetailsUiState>(InfantsBadHabitDetailsUiState()){

    private val args: InfantsBadHabitDetailsArgs = InfantsBadHabitDetailsArgs(savedStateHandle)

    init {
        getBadHabitById()
    }
    private fun getBadHabitById(){
        val id = args.id
        tryToExecute(
            {getInfantsBadHabitByIdUseCase(id)},
            ::onGetBadHabitByIdSuccess,
            ::onError
        )
    }


    private fun onGetBadHabitByIdSuccess(badHabit: InfantsBadHabitsEntity){
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