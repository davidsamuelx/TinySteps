package com.aa.usecase

import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.repositories.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
  //  private val validateLoginForm: ValidateLoginFormUseCase,
    private val authenticationRepository: AuthenticationRepository,

) {

    suspend operator fun invoke(
        userLoginAuth: UserLoginAuth
    ):UserInformation{
        return authenticationRepository
            .loginRequest(userLoginAuth)

//        val validationResults
//                = validateLoginForm(userLoginAuth.name,userLoginAuth.password)
//
//        if (validationResults.any { !it.isValid }) {
//            throw ErrorType.UnAuthorized(validationResults)
//        }
//        val user = authenticationRepository.loginRequest(userLoginAuth)
//        authenticationRepository.saveAuthData(user.token, true)

    }

}