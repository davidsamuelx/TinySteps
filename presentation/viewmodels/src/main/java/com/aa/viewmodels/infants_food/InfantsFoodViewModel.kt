package com.aa.viewmodels.infants_food

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsFoodEntity
import com.aa.usecase.infants.GetAllInfantsFoodUseCase
import com.aa.usecase.infants.SearchInfantsFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfantsFoodViewModel @Inject constructor(
    private val getAllInfantsFoodUseCase: GetAllInfantsFoodUseCase,
    private val searchInfantsFoodUseCase: SearchInfantsFoodUseCase
):BaseViewModel<InfantsFoodUIState>(InfantsFoodUIState()) {

    private var searchFood:Job? = null
    init {
        getAllFood()
    }


    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchFood?.cancel()
        searchFood = viewModelScope.launch {
            delay(300)
            onSearchClicked()
        }
    }


    private fun getAllFood(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllInfantsFoodUseCase() },
            ::onGetAllFoodSuccess,
            ::onError
        )
    }


    fun onSearchClicked() {
        val currentQuery = _state.value.query

        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchInfantsFoodUseCase(currentQuery) },
                ::onSearchSuccess,
                ::onError
            )
        }else {
            getAllFood()
        }
    }
    private fun onGetAllFoodSuccess(allFood: List<InfantsFoodEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                foodUIState = allFood.map {
                        allFoodEntity -> allFoodEntity.toUiState()
                })
        }
    }
    private fun onSearchSuccess(searchResults: List<InfantsFoodEntity>) {
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