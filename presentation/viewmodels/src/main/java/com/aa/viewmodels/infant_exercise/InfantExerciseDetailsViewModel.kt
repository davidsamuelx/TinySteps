package com.aa.viewmodels.infant_exercise

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsExerciseEntity
import com.aa.usecase.infants.SelectByIdInfantsExerciseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InfantExerciseDetailsViewModel@Inject constructor(
    private val selectByIdInfantsExerciseUseCase: SelectByIdInfantsExerciseUseCase,
    savedStateHandle: SavedStateHandle,
    ): BaseViewModel<InfantExerciseDetailsUiState>(InfantExerciseDetailsUiState()){

    private val args: InfantExerciseDetailsArgs = InfantExerciseDetailsArgs(savedStateHandle)

    init {
        getInfantExerciseDetails()
    }

    private fun getInfantExerciseDetails(){
        val id = args.id
        tryToExecute(
            { selectByIdInfantsExerciseUseCase(id) },
            ::onGetInfantExerciseDetailsSuccess,
            ::onError
        )
    }

    private fun onGetInfantExerciseDetailsSuccess(exercise: InfantsExerciseEntity){
        _state.update {
            it.copy(
                isLoading = false,
                exercise = exercise.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}