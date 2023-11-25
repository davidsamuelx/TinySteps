package com.aa.viewmodels.infants_products

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsProductsEntity
import com.aa.usecase.infants.GetInfantsProductsUseCase
import com.aa.usecase.infants.SearchInfantsProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfantsProductsViewModel  @Inject constructor(
    private val getInfantsProductsUseCase:GetInfantsProductsUseCase,
    private val searchInfantsProductsUseCase: SearchInfantsProductsUseCase
): BaseViewModel<InfantsProductsUiState>(InfantsProductsUiState()) {

    private var searchJob: Job? = null

    init {
        getInfantsProducts()
    }
    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onSearchClicked()
        }
    }
    private fun getInfantsProducts(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getInfantsProductsUseCase() },
            ::onGetInfantsProductsSuccess,
            ::onError
        )
    }
    private fun onGetInfantsProductsSuccess(infantsProducts: List<InfantsProductsEntity>){
        Log.d("Products", "onGetProductsByIdSuccess: $infantsProducts") // Log the data
        _state.update {
            it.copy(
                isLoading = false,
                infantsProductsList = infantsProducts.map {
                        infantsProductsEntity -> infantsProductsEntity.toUiState()
                })
        }
    }
    fun onSearchClicked(){
        val currentQuery = _state.value.query

        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchInfantsProductsUseCase(currentQuery) },
                ::onInfantsProductsSearchSuccess,
                ::onError
            )
        }else {
            getInfantsProducts()
        }
    }
    private fun onInfantsProductsSearchSuccess(searchResults: List<InfantsProductsEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                infantsProductsList = searchResults.map { searchInfantsProductsEntity ->
                    searchInfantsProductsEntity.toUiState()
                }
            )
        }
    }


    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}