package com.aa.usecase

import com.aa.models.PregnancyEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetPregnancyDataUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(): List<PregnancyEntity>{
        return pregnancyRepository.getPregnancyData()
    }
}