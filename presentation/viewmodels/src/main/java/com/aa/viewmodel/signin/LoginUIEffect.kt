package com.aa.viewmodel.signin

import com.aa.base.BaseErrorUiState

sealed interface LoginUIEffect {

    object LoginSuccess : LoginUIEffect

    class LoginFailed(val errorMessage: BaseErrorUiState?) : LoginUIEffect

    data class ShowSnackbar(val message: String) : LoginUIEffect


}