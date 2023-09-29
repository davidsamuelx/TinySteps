package com.aa.usecase

import com.aa.models.MusicEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllMusicUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(): List<MusicEntity>{
        return pregnancyRepository.getAllMusics()
    }
}