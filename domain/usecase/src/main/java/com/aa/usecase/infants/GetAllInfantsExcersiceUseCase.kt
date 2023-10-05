package com.aa.usecase.infants

import com.aa.models.infants.InfantsExcersiceEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsExcersiceUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository

) {
    suspend operator fun invoke (): List<InfantsExcersiceEntity> {
        return infantsRepository.infantsExcersice().shuffled()
}
}
