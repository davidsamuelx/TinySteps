package com.aa.repository.datasources

import com.aa.repository.resources.AllFoodAdviceResource

interface RemoteDataSource {

    suspend fun getFoodAdvices():AllFoodAdviceResource
}