package com.aa.viewmodel.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.UserSignUpAuth
import com.aa.usecase.SignupUseCase
import com.aa.viewmodel.signin.LoginUIEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel@Inject constructor(
    private val signUpUseCase: SignupUseCase
)
    :BaseViewModel<SignUpUiState>(SignUpUiState()) {



    private val _effect = MutableSharedFlow<LoginUIEffect>()
    val effect = _effect.asSharedFlow()

    fun signUp(username: String, email: String, password: String, pregnancyDate: String) {
        tryToExecute(
            function = {
                signUpUseCase.invoke(UserSignUpAuth(username, email, password, pregnancyDate, 5, password))
            },
             ::onSuccess,
            ::onError

        )
    }
    fun onChangedName(name:String){
        _state.update { it.copy(name = name) }
    }
    fun onChangedSurname(surname:String){
        _state.update { it.copy(surname = surname) }
    }
    fun onChangedEmail(email:String){
        _state.update { it.copy(email = email) }
    }
    fun onChangedPassword(password:String){
        _state.update { it.copy(password = password) }
    }
    fun onChangedPregnancyDate(pregnancyDate:String){
        _state.update { it.copy(pregnancyDate = pregnancyDate) }
    }

    fun onDeleteName(){
        _state.update { it.copy(name = "") }
    }
    fun onDeleteSurname(){
        _state.update { it.copy(surname = "") }
    }
    fun onDeleteEmail(){
        _state.update { it.copy(email = "") }
    }
    fun onDeletePassword(){
        _state.update { it.copy(password = "") }
    }
    fun onDeleteDatePregnancy(){
        _state.update { it.copy(pregnancyDate = "") }
    }




    private fun onSuccess(unit: Unit) {
        viewModelScope.launch {_effect.emit(LoginUIEffect.LoginSuccess)  }
        _state.update { it.copy(isLoading = true) }
    }


    private fun onError(error: BaseErrorUiState) {
        Log.e("SignInViewModel", "Error: ${error.errorCode}, Message: ${error.errorCode}")
        viewModelScope.launch {_effect.emit(LoginUIEffect.LoginFailed(error))  }
        _state.update { it.copy(error = error, isLoading = false) }
    }
}
