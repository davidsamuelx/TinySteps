package com.aa.usecase.infants

import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetIAllInfantsSpecialCaseUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke (): List<InfantsSpecialCaseEntity> {
        return infantsRepository.infantsSpecialCase().shuffled()
    }
}