package com.aa.viewmodels.food

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.AllFoodAdviceEntity
import com.aa.usecase.GetAllFoodAdviceUseCase
import com.aa.usecase.SearchFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getAllFoodUseCase: GetAllFoodAdviceUseCase,
    private val searchFoodUseCase: SearchFoodUseCase
): BaseViewModel<FoodUIState>(FoodUIState()){

    private var searchJob: Job? = null

    init {
        getAllFood()
    }

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onSearchClicked()
        }
    }

    private fun getAllFood(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllFoodUseCase() },
            ::onGetAllFoodSuccess,
            ::onError
        )
    }

    private fun onGetAllFoodSuccess(allFood: List<AllFoodAdviceEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                foodUIState = allFood.map {
                        allFoodEntity -> allFoodEntity.toUiState()
                })
        }
    }

    fun onSearchClicked() {
        val currentQuery = _state.value.query

        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchFoodUseCase(currentQuery) },
                ::onSearchSuccess,
                ::onError
            )
        }else {
            getAllFood()
        }
    }

    private fun onSearchSuccess(searchResults: List<AllFoodAdviceEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                foodUIState = searchResults.map { searchFoodEntity ->
                    searchFoodEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}