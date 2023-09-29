package com.aa.repository.datasources

import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.AllVideosResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource

interface RemoteDataSource {

    suspend fun getFoodAdvices(): AllFoodAdviceResource
    suspend fun loginRequest(
        loginResource: LoginResource,
    ): LoginResponseResource

    suspend fun storeBabyGender(
        storeBabyGenderResource: StoreBabyGenderResource
    ): BabyGenderResource

    suspend fun deleteBabyGender(id: String)

    suspend fun updateBabyGender(id: String, babyGender: String)

    suspend fun getAllVideos(): AllVideosResource
}