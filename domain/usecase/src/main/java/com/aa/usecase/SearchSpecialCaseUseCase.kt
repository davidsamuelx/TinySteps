package com.aa.usecase

import com.aa.models.SpecialCaseEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchSpecialCaseUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(specialCase: String): List<SpecialCaseEntity>{
        return pregnancyRepository.searchSpecialCase(specialCase)
    }
}