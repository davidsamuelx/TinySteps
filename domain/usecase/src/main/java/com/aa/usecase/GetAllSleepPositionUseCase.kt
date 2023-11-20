package com.aa.usecase

import com.aa.models.SleepPositionEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllSleepPositionUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(): List<SleepPositionEntity>{
        return pregnancyRepository.getAllSleepPosition()
    }
}