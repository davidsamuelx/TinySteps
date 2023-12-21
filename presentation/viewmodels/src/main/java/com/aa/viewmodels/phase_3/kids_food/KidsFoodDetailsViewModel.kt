package com.aa.viewmodels.phase_3.kids_food

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.KidsFoodEntity
import com.aa.usecase.kids.SelectKidsFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class KidsFoodDetailsViewModel @Inject constructor(
    private val selectKidsFoodUseCase: SelectKidsFoodUseCase,
    savedStateHandle: SavedStateHandle

):BaseViewModel<KidsFoodDetailsUiState>(KidsFoodDetailsUiState()) {

    private val args:KidsFoodDetailsArgs= KidsFoodDetailsArgs(savedStateHandle)
    init {
        getFoodById()
    }
    private fun getFoodById(){
        val id = args.id.toInt()
        tryToExecute(
            { selectKidsFoodUseCase(id) },
            ::onGetFoodByIdSuccess,
            ::onError
        )
    }


    private fun onGetFoodByIdSuccess(food: KidsFoodEntity){
        Log.d("FoodDetailsViewModel", "onGetFoodByIdSuccess: $food") // Log the data
        _state.update {
            it.copy(
                isLoading = false,
                food = food.toUiDetailsState()
            )
        }
    }


    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}