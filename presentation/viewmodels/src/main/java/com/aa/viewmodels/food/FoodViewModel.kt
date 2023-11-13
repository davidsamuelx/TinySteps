package com.aa.viewmodels.food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.AllFoodAdviceEntity
import com.aa.usecase.GetAllFoodAdviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getAllFoodUseCase: GetAllFoodAdviceUseCase
): BaseViewModel<FoodUIState>(FoodUIState()){

    init {
        getAllFood()
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

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}