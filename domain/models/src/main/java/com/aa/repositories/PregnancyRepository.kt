package com.aa.repositories

import com.aa.models.AllFoodAdviceEntity

interface PregnancyRepository {

    suspend fun allFoodAdvice():List<AllFoodAdviceEntity>
}
