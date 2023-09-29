package com.aa.usecase

import com.aa.models.MusicEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetMusicByIdUseCase@Inject constructor(
    private val pregnancyRepository: PregnancyRepository
)  {
    suspend operator fun invoke(id: Int):MusicEntity{
        return pregnancyRepository.getMusicById(id)
    }
}