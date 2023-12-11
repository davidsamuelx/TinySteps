package com.aa.viewmodels.splash

import com.aa.base.BaseUiState

data class SplashUiState(
    val isLoading : Boolean = true,
    val isLogged : Boolean = false
):BaseUiState