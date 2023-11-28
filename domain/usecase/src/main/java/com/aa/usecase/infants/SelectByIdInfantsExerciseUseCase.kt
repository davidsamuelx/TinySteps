package com.aa.usecase.infants

import com.aa.models.infants.InfantsExerciseEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SelectByIdInfantsExerciseUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:Int): InfantsExerciseEntity {
        return infantsRepository.selectByIdExcersie(id)
    }
}