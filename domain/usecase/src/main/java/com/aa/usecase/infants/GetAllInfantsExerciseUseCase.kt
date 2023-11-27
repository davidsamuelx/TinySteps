package com.aa.usecase.infants

import com.aa.models.infants.InfantsExerciseEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsExerciseUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository

) {
    suspend operator fun invoke (): List<InfantsExerciseEntity> {
        return infantsRepository.infantsExcersice().shuffled()
}
}
