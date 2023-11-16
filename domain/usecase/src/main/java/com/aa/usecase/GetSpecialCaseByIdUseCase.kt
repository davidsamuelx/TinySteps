package com.aa.usecase

import com.aa.models.SpecialCaseByIdEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetSpecialCaseByIdUseCase@Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int): SpecialCaseByIdEntity {
        return pregnancyRepository.getSpecialCaseById(id)
    }
}