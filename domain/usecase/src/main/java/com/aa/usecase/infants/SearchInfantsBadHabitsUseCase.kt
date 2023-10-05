package com.aa.usecase.infants

import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchInfantsBadHabitsUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(badHabit:String):List<InfantsBadHabitsEntity>{
        return infantsRepository.searchInfantsBadHabits(badHabit).shuffled()
    }
}