package com.aa.usecase.infants

import com.aa.models.infants.InfantsExerciseEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchForInfantsExerciseUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(videoPath:String):List<InfantsExerciseEntity>{
        return infantsRepository.searchInfantsExcersice(videoPath)
    }
}