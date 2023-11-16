package com.aa.usecase

import com.aa.models.AllFoodAdviceEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchFoodUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(foodSearch: String): List<AllFoodAdviceEntity>{
        return pregnancyRepository.searchFood(foodSearch)
    }
}