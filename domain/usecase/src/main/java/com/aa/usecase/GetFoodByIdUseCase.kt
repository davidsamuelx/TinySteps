package com.aa.usecase

import com.aa.models.AllFoodAdviceEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetFoodByIdUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int): AllFoodAdviceEntity {
        return pregnancyRepository.getFoodById(id)
    }
}