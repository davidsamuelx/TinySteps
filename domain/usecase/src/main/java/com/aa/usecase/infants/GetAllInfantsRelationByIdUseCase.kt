package com.aa.usecase.infants

import com.aa.models.InfantsRelationEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsRelationByIdUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:Int):InfantsRelationEntity{
        return infantsRepository.infantsRelationById(id)
    }
}