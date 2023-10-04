package com.aa.usecase.infants

import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsSpecialCaseByIdUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:Int): InfantsSpecialCaseEntity? {
        return infantsRepository.infantsSpecialCaseById(id)
    }
}