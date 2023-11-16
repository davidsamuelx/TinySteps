package com.aa.repository

import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.models.UserRegisterInformation
import com.aa.models.UserSignUpAuth
import com.aa.repositories.AuthenticationRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.datasources.SharedPreferenceDataSource
import com.aa.repository.mappers.toEntity
import com.aa.repository.mappers.toResource
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val sharedPreferenceDataSource: SharedPreferenceDataSource
): AuthenticationRepository {
    override suspend fun loginRequest(userLoginAuth: UserLoginAuth): UserInformation {
        val request = remoteDataSource.loginRequest(userLoginAuth.toResource()).toEntity()
        sharedPreferenceDataSource.saveUserToken(request.token)
         return request
    }

    override suspend fun signupRequest(userSignUpAuth: UserSignUpAuth): UserRegisterInformation {
        val request=remoteDataSource.signupRequest(userSignUpAuth.toResource()).toEntity()
        sharedPreferenceDataSource.saveUserToken(request.username)
        return request
    }

//    override suspend fun saveAuthData(token: String, isLogged: Boolean) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun getAuthToken(): String? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun getAuthTokenExpireTime(): Long? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun clearAuthData() {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun isLoggedIn(): Boolean {
//        TODO("Not yet implemented")
//    }


}