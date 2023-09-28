package com.aa.repositories

import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth

interface AuthenticationRepository {

    suspend fun loginRequest(
        userLoginAuth: UserLoginAuth
    ):UserInformation
}