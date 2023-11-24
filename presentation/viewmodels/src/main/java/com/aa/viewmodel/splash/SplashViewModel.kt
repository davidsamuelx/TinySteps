package com.aa.viewmodel.splash

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseViewModel
import com.aa.usecase.InitialScreenNavigationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val initialScreenNavigationUseCase: InitialScreenNavigationUseCase
) : BaseViewModel<SplashUiState>(SplashUiState()) {

    init {
        viewModelScope.launch { checkIfUserLogged() }
    }

    private suspend fun checkIfUserLogged() {
        if (initialScreenNavigationUseCase()) {
            _state.update { it.copy(isLoading = false, isLogged = true) }
        }
    }

}