package com.aa.usecase.kids

import com.aa.models.kids.AchievementsEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class AchievementsUseCase @Inject constructor(
   private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke():List<AchievementsEntity>{
        return kidsRepository.getAllAchievements()
    }
}