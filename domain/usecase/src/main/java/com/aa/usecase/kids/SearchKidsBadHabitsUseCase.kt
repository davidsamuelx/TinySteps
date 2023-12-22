package com.aa.usecase.kids

import com.aa.models.kids.KidsBadHabitEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class SearchKidsBadHabitsUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (badHabits:String): List<KidsBadHabitEntity> {
        return kidsRepository.searchKidsBadHabits(badHabits)
    }
}
