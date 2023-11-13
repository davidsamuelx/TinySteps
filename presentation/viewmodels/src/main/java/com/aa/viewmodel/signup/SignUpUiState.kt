package com.aa.viewmodel.signup

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState

data class SignUpUiState(
    val name:String="",
    val surname:String="",
    val email:String="",
    val password:String="",
    val pregnancyDate:String="",

    val errorMessage: String? = null, // This is the property we added
    val error: BaseErrorUiState? = null,
    val isValidName: Boolean = false,
    val isValidApiKey: Boolean = false,
    val isValidUsername: Boolean = false,
    val isValidEmail: Boolean = false,
    val isValidPassword: Boolean = false,
    val isValidPregnancyDate: Boolean = false,
    val isValidForm: Boolean = false,

    val isLoading: Boolean = false,
):BaseUiState{
}
