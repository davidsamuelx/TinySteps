package com.aa.usecase

import com.aa.models.MusicEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class SearchMusicByTypeUseCase@Inject constructor(
    private val pregnancyRepository: PregnancyRepository
)  {
    suspend operator fun invoke(musicType: String): List<MusicEntity> {
        return pregnancyRepository.getMusicByType(musicType)
    }
}