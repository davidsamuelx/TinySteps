package com.aa.usecase.infants

import com.aa.models.infants.InfantsExcersiceEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SelectByIdInfantsExcersiceUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:Int): InfantsExcersiceEntity {
        return infantsRepository.selectByIdExcersie(id)
    }
}