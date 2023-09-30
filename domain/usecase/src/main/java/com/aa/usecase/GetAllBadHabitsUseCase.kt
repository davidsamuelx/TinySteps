package com.aa.usecase

import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllBadHabitsUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke() {
        return pregnancyRepository.getAllBadHabit()
    }
}