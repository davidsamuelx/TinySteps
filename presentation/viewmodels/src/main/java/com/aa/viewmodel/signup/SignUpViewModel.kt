package com.aa.viewmodel.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aa.base.BaseViewModel
import com.aa.models.UserRegisterInformation
import com.aa.models.UserSignUpAuth
import com.aa.usecase.SignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel@Inject constructor(
    private val signUpUseCase: SignupUseCase
)
    :BaseViewModel<SignUpUiState>(SignUpUiState()) {


    private val _signUpResult = MutableLiveData<UserRegisterInformation>()
    val signUpResult: LiveData<UserRegisterInformation> get() = _signUpResult

//
//    private val _event = MutableSharedFlow<RegisterEvent>()
//    val event = _event.asSharedFlow()
//
//    fun register(userSignUpAuth: UserSignUpAuth){
//                tryToExecute(
//                    function =signUpUseCase(userSignUpAuth),
//                        ::signupSuccess,
//                        ::signupError
//                )
//        }
//    fun signupSuccess(userRegisterInformation: UserRegisterInformation){
//        val signup=userRegisterInformation.toSignupUiState()
//        _state.update { state->
//            state.copy(
//                name = signup.name,
//                password = signup.password,
//                pregnancyDate = signup.pregnancyDate,
//                email = signup.email
//            )
//        }
//    }
//    private fun signupError(error: BaseErrorUiState){
//        _state.update { state ->
//            state.copy(
//                isLoading = false,
//                error = error
//            )
//        }
//    }

    fun signUp(username: String, email: String, password: String, pregnancyDate: String) {
        tryToExecute(
            function = {
                signUpUseCase.invoke(UserSignUpAuth(username, email, password, pregnancyDate, 5, password))
            },
            onSuccess = { result ->
                _signUpResult.value = result
            },
            onError = { error ->
                updateState { currentState ->
                    currentState.copy(errorMessage = error.errorCode)
                }
            }
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

//    private fun UserRegisterInformation.toSignupUiState():SignUpUiState{
//        return SignUpUiState(
//            email=email,
//            password = password,
//            pregnancyDate = startDate,
//            name = username
//        )
//    }
}
