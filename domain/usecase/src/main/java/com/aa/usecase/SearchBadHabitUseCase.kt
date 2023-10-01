package com.aa.usecase

import com.aa.models.BadHabitEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchBadHabitUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(badHabit: String): List<BadHabitEntity>{
        return pregnancyRepository.searchBadHabit(badHabit)
    }
}