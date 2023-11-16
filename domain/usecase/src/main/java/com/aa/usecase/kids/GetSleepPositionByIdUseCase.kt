package com.aa.usecase.kids

import com.aa.models.SleepPositionEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetSleepPositionByIdUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id:Int): SleepPositionEntity{
        return pregnancyRepository.getSleepPositionById(id)
    }
}