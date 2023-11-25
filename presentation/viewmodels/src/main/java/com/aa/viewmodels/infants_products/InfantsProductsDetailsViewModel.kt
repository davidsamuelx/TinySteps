package com.aa.viewmodels.infants_products

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsProductsEntity
import com.aa.usecase.infants.SelectInfantsProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InfantsProductsDetailsViewModel@Inject constructor(
    private val getInfantsProductsByIdUseCase: SelectInfantsProductsUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<InfantsProductsDetailsUiState>(InfantsProductsDetailsUiState()) {

    private val args: InfantsProductsArgs = InfantsProductsArgs(savedStateHandle)

    init {
        getProductBYId()
    }
    private fun getProductBYId(){
        val id = args.id
        tryToExecute(
            {getInfantsProductsByIdUseCase(id)},
            ::onGetInfantsProductsByIdSuccess,
            ::onError
        )
    }

    private fun onGetInfantsProductsByIdSuccess(product: InfantsProductsEntity){
        Log.d("Products", "onGetProductsByIdSuccess: $product") // Log the data
        _state.update {
            it.copy(
                isLoading = false,
                infantsProducts = product.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}