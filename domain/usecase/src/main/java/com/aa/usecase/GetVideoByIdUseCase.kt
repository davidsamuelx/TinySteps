package com.aa.usecase

import com.aa.models.ExerciseEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetVideoByIdUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int):ExerciseEntity{
        return pregnancyRepository.getVideoById(id)
    }
}