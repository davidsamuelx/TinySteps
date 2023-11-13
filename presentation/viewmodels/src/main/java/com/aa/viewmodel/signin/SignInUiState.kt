package com.aa.viewmodel.signin

import com.aa.base.BaseUiState

data class SignInUiState(
    val email:String = "",
    val password:String ="",

    val isUserNameValid: Boolean = false,
    val isPasswordValid: Boolean = false,

    val userNameError: String = "",
    val passwordError: String = "",

    val isLoading: Boolean = false,
):BaseUiState{

}

