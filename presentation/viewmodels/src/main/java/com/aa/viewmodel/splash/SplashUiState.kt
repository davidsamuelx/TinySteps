package com.aa.viewmodel.splash

import com.aa.base.BaseUiState

data class SplashUiState(
    val isLoading : Boolean = true,
    val isLogged : Boolean = false
):BaseUiState