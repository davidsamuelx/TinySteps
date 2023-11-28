package com.aa.viewmodels.infants_food

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsFoodEntity
import com.aa.usecase.infants.GetAllInfantsfoodByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class InfantsFoodDetailsViewModel @Inject constructor(
    private val getAllInfantsfoodByIdUseCase: GetAllInfantsfoodByIdUseCase,
    savedStateHandle: SavedStateHandle

):BaseViewModel<InfantsFoodDetailsUiState>(InfantsFoodDetailsUiState()) {

    private val args:InfantsFoodDetailsArgs= InfantsFoodDetailsArgs(savedStateHandle)
    init {
        getFoodById()
    }
    private fun getFoodById(){
        val id = args.id.toInt()
        tryToExecute(
            { getAllInfantsfoodByIdUseCase(id) },
            ::onGetFoodByIdSuccess,
            ::onError
        )
    }


    private fun onGetFoodByIdSuccess(food: InfantsFoodEntity){
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