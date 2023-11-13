package com.aa.base.viewmodels.cateories.exercise

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.base.BaseViewModel
import com.aa.models.ExerciseEntity
import com.aa.usecase.GetAllVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val getAllVideosUseCase: GetAllVideosUseCase
): BaseViewModel<ExercisesUiState>(ExercisesUiState()){

    init {
        getAllExercises()
    }

    private fun getAllExercises(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllVideosUseCase() },
            ::onGetAllExercisesSuccess,
            ::onError
        )
    }

    private fun onGetAllExercisesSuccess(allExercises: List<ExerciseEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                exercisesList = allExercises.map {
                    allExercises -> allExercises.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}