package com.aa.usecase

import com.aa.repositories.AuthenticationRepository
import javax.inject.Inject

class InitialScreenNavigationUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
) {

    suspend operator fun invoke(): Boolean {
        return authenticationRepository.isLoggedIn()
    }


}