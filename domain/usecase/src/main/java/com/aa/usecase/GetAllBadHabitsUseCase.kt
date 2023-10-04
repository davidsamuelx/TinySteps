package com.aa.usecase

import com.aa.models.BadHabitEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllBadHabitsUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke() : List<BadHabitEntity>  {
        return pregnancyRepository.getAllBadHabit()
    }
}