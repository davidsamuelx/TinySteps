package com.aa.usecase

import com.aa.models.ExerciseEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllVideosUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(): List<ExerciseEntity> {
        return pregnancyRepository.allVideos().shuffled()
    }
}