package com.aa.viewmodel.signin

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.UserLoginAuth
import com.aa.usecase.LoginUseCase
import com.aa.usecase.validations.ValidatePasswordUseCase
import com.aa.usecase.validations.ValidateUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel@Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val validateUsername: ValidateUsernameUseCase,
    private val validatePassword: ValidatePasswordUseCase,

    )
    :BaseViewModel<SignInUiState>(SignInUiState()) {

    private val _effect = MutableSharedFlow<LoginUIEffect>()
    val effect = _effect.asSharedFlow()

    fun login(username: String, password: String) {
    tryToExecute(
        function = {
            loginUseCase.invoke(UserLoginAuth(username,  password))

        },
        onSuccess = ::onSuccess,
        onError =::onError
    )
    }
    fun onChangedEmail(email: String) {
        _state.update {
            it.copy(
                name = email,


            )


        }


    }

    fun onChangedPassword(password: String) {
        _state.update {
            it.copy(
                password = password,

           )
        }
    }

    fun onDeleteEmail() {
        _state.update { it.copy(name = "") }

    }

    fun onDeletePassword() {
        _state.update { it.copy(password = "") }
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
