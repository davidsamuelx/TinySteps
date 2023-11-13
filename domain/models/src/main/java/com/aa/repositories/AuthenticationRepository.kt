package com.aa.repositories

import com.aa.models.Token
import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.models.UserRegisterInformation
import com.aa.models.UserSignUpAuth

interface AuthenticationRepository {

    suspend fun loginRequest(
        userLoginAuth: UserLoginAuth
    ): UserInformation

    suspend fun signupRequest(
        userSignUpAuth: UserSignUpAuth
    ):UserRegisterInformation



//    suspend fun saveAuthData(token: Token, isLogged : Boolean)
//
//    suspend fun getAuthToken(): String?
//
//    suspend fun getAuthTokenExpireTime(): Long?
//
//    suspend fun clearAuthData()
//    suspend fun isLoggedIn() : Boolean
}
