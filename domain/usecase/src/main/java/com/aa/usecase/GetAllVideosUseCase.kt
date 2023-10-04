package com.aa.usecase

import com.aa.models.VideosEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllVideosUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(): List<VideosEntity> {
        return pregnancyRepository.allVideos().shuffled()
    }
}