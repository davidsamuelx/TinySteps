package com.aa.usecase

import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class UpdateENSupportMessageUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(
        messageId: Int,
        messageType: String
    ) {
        return pregnancyRepository.updateEnSupportMessage(
            messageId = messageId,
            messageType = messageType
        )
    }
}