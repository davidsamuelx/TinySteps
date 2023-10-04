package com.aa.usecase

import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class DeleteENSupportMessageUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (messageId: Int){
        return pregnancyRepository.deleteEnSupportMessage(messageId)
    }
}