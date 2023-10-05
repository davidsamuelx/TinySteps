package com.aa.usecase.infants

import com.aa.models.infants.InfantsRelationEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchInfantsRealtionUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:String):List<InfantsRelationEntity>{
        return infantsRepository.searchInfantsRelation(id).shuffled()
    }
}