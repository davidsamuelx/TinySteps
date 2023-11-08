package com.aa.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState : BaseUiState>(state: UiState) : ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (code: BaseErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = function()
                onSuccess(result)
            } catch (e: Throwable) {
                onError(BaseErrorUiState.NetworkError(e.message.toString()))
            }
        }
    }
}