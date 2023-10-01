package com.aa.usecase

import com.aa.models.SearchFoodEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetFoodByIdUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int): SearchFoodEntity {
        return pregnancyRepository.getFoodById(id)
    }
}