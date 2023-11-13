package com.aa.viewmodel.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aa.base.BaseViewModel
import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.models.UserRegisterInformation
import com.aa.viewmodel.signin.SignInUiState
import com.aa.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel@Inject constructor(
    private val loginUseCase: LoginUseCase,

)
    :BaseViewModel<SignInUiState>(SignInUiState()) {
    private val _signInResult = MutableLiveData<UserInformation>()
    val signInResult: LiveData<UserInformation> get() = _signInResult

//    private val _event = MutableSharedFlow<LoginEvent>()
//    val event = _event.asSharedFlow()

//    fun login() {
//        updateState { it.copy(isLoading = true) }
//            tryToExecute(
//                function ={
//                loginUseCase(
//                    userLoginAuth =userLoginAuth
//                )
//                },
//
//            )
//    }
//    private fun onLoginSuccess(unit: Unit) {
//        updateState { it.copy(isLoading = false) }
//        viewModelScope.launch { _event.emit(LoginEvent.NavigateToHome) }
//    }

    fun onChangedEmail(email: String) {
        _state.update { it.copy(email = email) }
    }

    fun onChangedPassword(password: String) {
        _state.update { it.copy(password = password) }
    }

    fun onDeleteEmail() {
        _state.update { it.copy(email = "") }
    }

    fun onDeletePassword() {
        _state.update { it.copy(password = "") }
    }


}