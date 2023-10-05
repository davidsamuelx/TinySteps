package com.aa.usecase.infants

import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfnatsBadHabitsUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke (): List<InfantsBadHabitsEntity> {
        return infantsRepository.infantsBadHabits().shuffled()
    }
}