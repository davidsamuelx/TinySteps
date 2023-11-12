package com.aa.usecase

import com.aa.models.ImageEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (id:Int): ImageEntity{
        return pregnancyRepository.getImage(id)
    }
}