package com.aa.usecase.infants

import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllGuidanceUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke (): List<GuidanceInstructionEntity> {
        return infantsRepository.guidanceInstruction().shuffled()
    }

}