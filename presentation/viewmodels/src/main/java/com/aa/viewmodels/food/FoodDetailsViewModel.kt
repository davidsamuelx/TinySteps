package com.aa.viewmodels.food

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.AllFoodAdviceEntity
import com.aa.usecase.GetFoodByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FoodDetailsViewModel @Inject constructor(
    private val getFoodByIdUseCase: GetFoodByIdUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<FoodDetailsUiState>(FoodDetailsUiState()){

    private val args: FoodDetailsArgs = FoodDetailsArgs(savedStateHandle)

    init {
        getFoodById()
    }

    private fun getFoodById(){
        val id = args.id.toInt()
        tryToExecute(
            { getFoodByIdUseCase(id) },
            ::onGetFoodByIdSuccess,
            ::onError
        )
    }

    private fun onGetFoodByIdSuccess(food: AllFoodAdviceEntity){
        Log.d("FoodDetailsViewModel", "onGetFoodByIdSuccess: $food") // Log the data
        _state.update {
            it.copy(
                isLoading = false,
                food = food.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }


}