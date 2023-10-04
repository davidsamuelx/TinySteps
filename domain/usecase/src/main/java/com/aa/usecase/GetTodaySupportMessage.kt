package com.aa.usecase

import com.aa.models.TodayENSupportMessageEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetTodaySupportMessage @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (): TodayENSupportMessageEntity{
        return pregnancyRepository.getTodaySupportMessage()
    }
}