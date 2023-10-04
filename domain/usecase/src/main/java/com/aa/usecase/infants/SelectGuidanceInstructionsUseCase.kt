package com.aa.usecase.infants

import com.aa.models.GuidanceInstructionEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SelectGuidanceInstructionsUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:String):GuidanceInstructionEntity{
        return infantsRepository.selectGuidanceInstruction(id)
    }
}