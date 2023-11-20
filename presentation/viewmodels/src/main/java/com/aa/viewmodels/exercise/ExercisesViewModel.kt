package com.aa.viewmodels.exercise

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.ExerciseEntity
import com.aa.usecase.GetAllVideosUseCase
import com.aa.usecase.SearchVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor(
    private val getAllVideosUseCase: GetAllVideosUseCase,
    private val searchVideosUseCase: SearchVideosUseCase
): BaseViewModel<ExercisesUiState>(ExercisesUiState()){

    private var searchJob: Job? = null

    init {
        getAllExercises()
    }

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onExerciseSearchClicked()
        }
    }

    fun onExerciseSearchClicked() {
        val currentQuery = _state.value.query
        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchVideosUseCase(currentQuery) },
                ::onExerciseSearchSuccess,
                ::onError
            )
        }else {
            getAllExercises()
        }
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

    private fun onExerciseSearchSuccess(searchResults: List<ExerciseEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                exercisesList = searchResults.map { searchExerciseEntity ->
                    searchExerciseEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}