package com.aa.viewmodels.phase_3.math_land_screen

import androidx.compose.runtime.mutableStateOf
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.MathLandEntity
import com.aa.usecase.kids.MathLandUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MathLandViewModel @Inject constructor(
    private val getMathLandUseCase: MathLandUseCase
) : BaseViewModel<MathLandUiState>(MathLandUiState()){

    var currentItemIndex = 0
    var mathLandListChanged = mutableStateOf(false)


    init {
        getMathLand()
    }


    fun getMathLand(level: String = "easy"){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getMathLandUseCase(level) },
            ::onGetMathLandSuccess,
            ::onGetError
        )
    }

    fun updateSelectedLevel(level: String) {
        _state.update { it.copy(selectedLevel = level, isAnswerSelected = false) }
    }

    fun updateSelectedAnswer(isCorrect: Boolean) {
        if (isCorrect) {
            _state.update { it.copy(isCorrectAnswerSelected = true) }
            CoroutineScope(Dispatchers.Main).launch {
                delay(1000)
                if (currentItemIndex < _state.value.mathLandList.size - 1) {
                    currentItemIndex++
                    _state.update { it.copy(isAnswerSelected = true, isCorrectAnswerSelected = false) }
                    refreshData(_state.value.selectedLevel)
                } else {
                    _state.update { it.copy(isAnswerSelected = true) }
                }
            }
        } else {
            _state.update { it.copy(isAnswerSelected = true) }
        }
    }

    private fun refreshData(level: String) {
        getMathLand(level)
        _state.update { it.copy(isAnswerSelected = false) }
    }

    private fun onGetMathLandSuccess(mathLand: List<MathLandEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                mathLandList = mathLand.map { mathLandEntity ->
                    mathLandEntity.toUiState()
                }
            )
        }
        mathLandListChanged.value = true
    }

    private fun onGetError(error: BaseErrorUiState){
            _state.update { state ->
                state.copy(
                    isLoading = false,
                    error = error
                )
            }
    }
}