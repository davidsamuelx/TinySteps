package com.aa.viewmodels.phase_3.kids_food

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.KidsFoodEntity
import com.aa.usecase.kids.GetAllKidsFoodUseCase
import com.aa.usecase.kids.SearchKidsFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KidsFoodViewModel @Inject constructor(
    private val getAllKidsFoodUseCase: GetAllKidsFoodUseCase,
    private val searchKidsFoodUseCase: SearchKidsFoodUseCase
):BaseViewModel<KidsFoodUIState>(KidsFoodUIState()) {

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
            { getAllKidsFoodUseCase() },
            ::onGetAllFoodSuccess,
            ::onError
        )
    }


    fun onSearchClicked() {
        val currentQuery = _state.value.query

        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchKidsFoodUseCase(currentQuery) },
                ::onSearchSuccess,
                ::onError
            )
        }else {
            getAllFood()
        }
    }
    private fun onGetAllFoodSuccess(allFood: List<KidsFoodEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                foodUIState = allFood.map {
                        allFoodEntity -> allFoodEntity.toUiState()
                })
        }
    }
    private fun onSearchSuccess(searchResults: List<KidsFoodEntity>) {
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