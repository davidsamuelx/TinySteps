package com.aa.usecase.infants

import com.aa.models.infants.InfantsFoodEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsFoodUseCase @Inject constructor(
    private val  infantsRepository: InfantsRepository
) {
    suspend operator fun invoke (): List<InfantsFoodEntity> {
        return infantsRepository.infantsFood().shuffled()
    }
}