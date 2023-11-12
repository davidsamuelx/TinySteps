package com.aa.viewmodels.baby_details_screen

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.ImageEntity
import com.aa.usecase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BabyDetailsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getImageUseCase: GetImageUseCase,
): BaseViewModel<BabyDetailsUiState>(BabyDetailsUiState()){

private val args:BabyDetailsArgs = BabyDetailsArgs(savedStateHandle)

    init {
        getBabyDetails(args.id.toInt())
        println(args.id)
    }

   private fun getBabyDetails(id: Int) {
        tryToExecute({
                getImageUseCase(id)
            },
            ::onGetBabyDetailsSuccess,
            ::onGetBabyDetailsError
        )
    }

    private fun onGetBabyDetailsSuccess(imageEntity: ImageEntity){
        val babyDetails = imageEntity.toImageUiState()
        _state.update { state ->
            state.copy(
                isLoading = false,
                babyImage = babyDetails.babyImage,
                babyInfo = babyDetails.babyInfo,
                weekNumber = babyDetails.weekNumber,
            )
        }
    }

    private fun onGetBabyDetailsError(error: BaseErrorUiState){
        _state.update { state ->
            state.copy(
                isLoading = false,
                error = error
            )
        }
    }


    private fun ImageEntity.toImageUiState(): BabyDetailsUiState {
        return BabyDetailsUiState(
            babyImage = imageUrl,
            babyInfo = details,
            weekNumber = weekNumber,
        )
    }

}