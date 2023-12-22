package com.aa.usecase.kids

import com.aa.models.kids.KidsBadHabitEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class SelectKidsBadHabitsUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (id:Int):KidsBadHabitEntity{
        return kidsRepository.selectKidsBadHabits(id)
    }
}