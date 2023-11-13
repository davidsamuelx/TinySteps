package com.aa.usecase

import com.aa.models.AllFoodAdviceEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllFoodAdviceUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
//    suspend operator fun invoke (): List<AllFoodAdviceEntity> {
//        return pregnancyRepository.allFoodAdvice().shuffled()
//    }
}