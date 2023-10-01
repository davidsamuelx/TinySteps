package com.aa.usecase

import com.aa.models.BadHabitEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetBadHabitByIdUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int): BadHabitEntity{
        return pregnancyRepository.getAllBadHabitById(id)
    }
}