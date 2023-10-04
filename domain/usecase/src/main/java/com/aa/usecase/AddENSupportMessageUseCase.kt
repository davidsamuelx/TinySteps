package com.aa.usecase

import com.aa.models.SelectedSupportMessageEntity
import com.aa.models.SupportMessageEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class AddENSupportMessageUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(
        selectedSupportMessageEntity: SelectedSupportMessageEntity
    ): SupportMessageEntity{
        return pregnancyRepository.addENSupportMessage(selectedSupportMessageEntity)
    }
}