package com.aa.viewmodels.home_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.ImageEntity
import com.aa.usecase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase,
) : BaseViewModel<HomeUiState>(HomeUiState()) {

init {
    onCalenderItemSelected(1)
}
    fun onCalenderItemSelected(id: Int) {
        tryToExecute({
                getImageUseCase(id)
            },
            ::onGetImageSuccess,
            ::onGetImageError
        )
    }

    private fun onGetImageSuccess(imageEntity: ImageEntity){
        val image = imageEntity.toImageUiState()
           _state.update { state ->
            state.copy(
                isLoading = false,
                isError = false,
                babyImage = image.babyImage,
                babyInfo = image.babyInfo,
                weekId = image.weekId,
                selectedCalendarItem = image.weekId
            )
        }
    }

    private fun onGetImageError(error: BaseErrorUiState){
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = true,
                error = error
            )
        }
    }
}


private fun ImageEntity.toImageUiState(): HomeUiState {
    return HomeUiState(
        babyImage = this.imageUrl,
        babyInfo = this.details,
        weekId = this.weekNumber,
    )
}