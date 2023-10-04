package com.aa.usecase

import com.aa.models.VideosEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetVideoById @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int):VideosEntity{
        return pregnancyRepository.getVideoById(id)
    }
}