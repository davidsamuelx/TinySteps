package com.aa.usecase

import com.aa.models.AllSupportMessagesEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class GetAllENSupportMessagesUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(): List<AllSupportMessagesEntity>{
        return pregnancyRepository.allENSupportMessage()
    }
}