package com.aa.repository

import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.repositories.AuthenticationRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import com.aa.repository.mappers.toResource
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): AuthenticationRepository {
    override suspend fun loginRequest(userLoginAuth: UserLoginAuth): UserInformation {
         return remoteDataSource.loginRequest(userLoginAuth.toResource()).toEntity()
    }
}