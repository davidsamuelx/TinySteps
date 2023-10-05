package com.aa.usecase.infants

import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchInfantsSpecialCaseUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(specialSearch:String):List<InfantsSpecialCaseEntity> {
        return infantsRepository.searchInfantsSpecialCase(specialSearch).shuffled()
    }
}