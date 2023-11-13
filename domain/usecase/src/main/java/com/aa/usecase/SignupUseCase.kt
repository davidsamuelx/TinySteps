package com.aa.usecase

import com.aa.models.UserInformation
import com.aa.models.UserRegisterInformation
import com.aa.models.UserSignUpAuth
import com.aa.repositories.AuthenticationRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    suspend operator fun invoke(userSignUpAuth: UserSignUpAuth)
    : UserRegisterInformation {
            return authenticationRepository
                .signupRequest(userSignUpAuth)

    }
}