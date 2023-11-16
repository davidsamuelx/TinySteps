package com.aa.usecase

import com.aa.models.SleepPositionEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchSleepPositionUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(sleepPosition: String): List<SleepPositionEntity>{
        return pregnancyRepository.searchSleepPosition(sleepPosition)
    }
}