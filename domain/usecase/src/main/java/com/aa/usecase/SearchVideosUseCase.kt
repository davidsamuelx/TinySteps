package com.aa.usecase

import com.aa.models.ExerciseEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchVideosUseCase@Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(name: String): List<ExerciseEntity>{
        return pregnancyRepository.getVideoByName(name)
    }
}