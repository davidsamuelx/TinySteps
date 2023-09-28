package com.aa.usecase

import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.repositories.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(
        userLoginAuth: UserLoginAuth
    ): UserInformation{
        return authenticationRepository.loginRequest(userLoginAuth)
    }
}