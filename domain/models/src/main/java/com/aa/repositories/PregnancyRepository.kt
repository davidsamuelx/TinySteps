package com.aa.repositories

import com.aa.models.AllFoodAdviceEntity
import com.aa.models.BabyGenderEntity
import com.aa.models.StoreBabyGenderEntity

interface PregnancyRepository {

    suspend fun allFoodAdvice():List<AllFoodAdviceEntity>

    suspend fun storeBabyGender(storeBabyGenderEntity: StoreBabyGenderEntity):BabyGenderEntity

    suspend fun deleteBabyGender(id: String)

    suspend fun updateBabyGender( babyId: String, babyGender: String)

}
