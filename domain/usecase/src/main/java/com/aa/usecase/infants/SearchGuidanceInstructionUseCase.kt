package com.aa.usecase.infants

import com.aa.models.GuidanceInstructionEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchGuidanceInstructionUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:String):List<GuidanceInstructionEntity>{
        return infantsRepository.searchGuidanceInstruction(id).shuffled()
    }
}