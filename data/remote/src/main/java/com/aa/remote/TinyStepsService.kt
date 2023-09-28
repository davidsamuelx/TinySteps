package com.aa.remote

import com.aa.repository.resources.AllFoodAdviceResource
import retrofit2.Response
import retrofit2.http.GET

interface TinyStepsService {
    @GET("getData/Phase01/all-food")
    suspend fun getFoodAdvices():Response<AllFoodAdviceResource>

}