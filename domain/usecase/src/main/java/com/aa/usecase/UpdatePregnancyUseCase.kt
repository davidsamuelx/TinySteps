package com.aa.usecase

import com.aa.models.UpdatePregnancyEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class UpdatePregnancyUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(
        id: Int,
        startDate: String
    ) : UpdatePregnancyEntity{
        return pregnancyRepository.updatePregnancy(
            id = id,
            startTime = startDate
        )
    }
}