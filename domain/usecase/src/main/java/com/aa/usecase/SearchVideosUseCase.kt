package com.aa.usecase

import com.aa.models.VideosEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchVideosUseCase@Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(name: String): List<VideosEntity>{
        return pregnancyRepository.getVideoByName(name)
    }
}