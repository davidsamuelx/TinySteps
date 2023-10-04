package com.aa.usecase.infants

import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfanatsBadHabitsByIdUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke (id:Int): InfantsBadHabitsEntity? {
        return infantsRepository.infantsBadHabitsById(id)
    }
}