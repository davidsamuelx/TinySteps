package com.aa.viewmodels.diff_images

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.DiffImageGameEntity
import com.aa.usecase.kids.DiffImageGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiffOfTwoImageViewModel @Inject constructor(
    private val diffImageGameUseCase: DiffImageGameUseCase
):BaseViewModel<DiffOfTwoImagesUiState>(DiffOfTwoImagesUiState()) {

    var currentItemIndex = 0
    var diffOfImageChanged = mutableStateOf(false)

    init {
        getDiffTwoImage()
    }
    fun getDiffTwoImage(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            {diffImageGameUseCase()},
            ::onGetDiffImages,
            ::onError

        )
    }

    private fun onGetDiffImages(diffImages:List<DiffImageGameEntity>){
        Log.d("DiffIm", "onGetDiffImages: $diffImages") // Log the data
            _state.update {
                it.copy(
                    isLoading = false,
                    diffOfTwoImage = diffImages.map { diffImageGameEntity ->
                        diffImageGameEntity.toUiState()
                    }

                )
            }
        diffOfImageChanged.value=true
    }
    fun updateSelectedAnswer(isCorrect: Boolean) {
        if (isCorrect) {
            _state.update { it.copy(isCorrectAnswerSelected = true) }
            CoroutineScope(Dispatchers.Main).launch{
                delay(1000)
                if(currentItemIndex<state.value.diffOfTwoImage.size-1){
                    currentItemIndex++
                    _state.update { it.copy(isAnswerSelected = true, isCorrectAnswerSelected = false) }
                }else{
                    _state.update { it.copy(isAnswerSelected = true) }
                }
            }
        }else{
            _state.update { it.copy(isAnswerSelected = true) }
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}