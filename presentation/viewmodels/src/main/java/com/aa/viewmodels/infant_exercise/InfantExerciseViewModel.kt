package com.aa.viewmodels.infant_exercise

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsExerciseEntity
import com.aa.usecase.infants.GetAllInfantsExerciseUseCase
import com.aa.usecase.infants.SearchForInfantsExerciseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfantExerciseViewModel @Inject constructor(
    private val getAllInfantsExerciseUseCase: GetAllInfantsExerciseUseCase,
    private val searchForInfantsExerciseUseCase: SearchForInfantsExerciseUseCase
): BaseViewModel<InfantExerciseUiState>(InfantExerciseUiState()){

    private var searchJob: Job? = null

    init {
        getAllInfantExercises()
    }



    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onInfantExerciseSearchClicked()
        }
    }

    fun onInfantExerciseSearchClicked(){
        val currentQuery = _state.value.query
        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchForInfantsExerciseUseCase(currentQuery) },
                ::onInfantExerciseSearchSuccess,
                ::onError
            )
        }
    }


    private fun getAllInfantExercises(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllInfantsExerciseUseCase() },
            ::onGetAllInfantExerciseSuccess,
            ::onError
        )
    }

    private fun onGetAllInfantExerciseSuccess(allExercises: List<InfantsExerciseEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                exercisesList = allExercises.map { allExercises ->
                    allExercises.toUiState()
                }
            )
        }
    }


    private fun onInfantExerciseSearchSuccess(searchResult: List<InfantsExerciseEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                exercisesList = searchResult.map { searchExerciseEntity ->
                    searchExerciseEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}