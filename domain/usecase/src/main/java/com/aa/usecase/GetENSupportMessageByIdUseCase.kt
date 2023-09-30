package com.aa.usecase

import com.aa.models.SupportMessageEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetENSupportMessageByIdUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(id: Int): SupportMessageEntity {
        return pregnancyRepository.getENSupportMessageById(id)
    }
}