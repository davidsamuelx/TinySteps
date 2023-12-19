package com.aa.viewmodels.signin

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState

data class SignInUiState(
    val name:String = "",
    val password:String ="",

    val isUserNameValid: Boolean = false,
    val isPasswordValid: Boolean = false,

    val userNameError: String? = "",
    val passwordError: String? = "",

    val error:BaseErrorUiState?=null,
    val isLoading: Boolean = false,
):BaseUiState{

}

data class ErrorWrapper(
    val errorMessage: String = "",
    val isError: Boolean = false
)