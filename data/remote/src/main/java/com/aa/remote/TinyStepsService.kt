package com.aa.remote

import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TinyStepsService {
    @GET("user/getData/Phase01/all-food")
    suspend fun getFoodAdvices():Response<AllFoodAdviceResource>

    @POST("auth/user/login")
    suspend fun loginRequest(
        @Body loginResource: LoginResource
    ):Response<LoginResponseResource>

    @POST("user/Pregnancy/BabyKind/store")
    suspend fun storeBabyGender(@Body babyGender: StoreBabyGenderResource): Response<BabyGenderResource>

}