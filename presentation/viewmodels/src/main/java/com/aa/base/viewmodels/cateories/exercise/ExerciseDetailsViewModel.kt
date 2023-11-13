package com.aa.base.viewmodels.cateories.exercise

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.base.viewmodels.cateories.music.MusicDetailsArgs
import com.aa.models.ExerciseEntity
import com.aa.usecase.GetVideoByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ExerciseDetailsViewModel @Inject constructor(
    private val getVideoByIdUseCase: GetVideoByIdUseCase,
    savedStateHandle: SavedStateHandle,
): BaseViewModel<ExerciseDetailsUiState>(ExerciseDetailsUiState()) {

    private val args: ExerciseDetailsArgs = ExerciseDetailsArgs(savedStateHandle)

    init {
        getExerciseDetails()
    }

    private fun getExerciseDetails(){
        val id = args.id.toInt()
        tryToExecute(
            {getVideoByIdUseCase(id)},
            ::onGetExerciseDetailsSuccess,
            ::onError
        )
    }

    private fun onGetExerciseDetailsSuccess(exercise: ExerciseEntity){
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