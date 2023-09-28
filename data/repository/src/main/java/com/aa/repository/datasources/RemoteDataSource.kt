package com.aa.repository.datasources

import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource

interface RemoteDataSource {

    suspend fun getFoodAdvices(): AllFoodAdviceResource
    suspend fun loginRequest(
        loginResource: LoginResource,
    ): LoginResponseResource
}