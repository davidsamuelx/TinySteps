package com.aa.usecase.kids

import com.aa.models.kids.KidsBadHabitEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class GetAllKidsBadHabitsUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke ():List<KidsBadHabitEntity>{
        return kidsRepository.getAllKidsBadHabits().shuffled()
    }
}