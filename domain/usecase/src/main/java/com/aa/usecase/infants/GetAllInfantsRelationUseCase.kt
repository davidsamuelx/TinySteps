package com.aa.usecase.infants

import com.aa.models.infants.InfantsRelationEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsRelationUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository

){
    suspend operator fun invoke():List<InfantsRelationEntity>{
        return infantsRepository.infantsRelation().shuffled()
    }
}