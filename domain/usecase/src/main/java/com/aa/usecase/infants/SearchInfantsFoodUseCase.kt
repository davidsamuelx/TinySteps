package com.aa.usecase.infants

import com.aa.models.infants.InfantsFoodEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchInfantsFoodUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(foodSearch:String):List<InfantsFoodEntity>{
        return infantsRepository.searchInfantsFood(foodSearch).shuffled()
    }
}