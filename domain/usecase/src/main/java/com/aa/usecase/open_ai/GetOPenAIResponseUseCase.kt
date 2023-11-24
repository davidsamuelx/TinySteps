package com.aa.usecase.open_ai

import com.aa.models.open_ai.OpenAIRequestEntity
import com.aa.models.open_ai.OpenAIResponseEntity
import com.aa.repositories.OpenAIRepository
import javax.inject.Inject

class GetOPenAIResponseUseCase @Inject constructor(
    private val openAIRepository: OpenAIRepository
) {
    suspend operator fun invoke(openAIRequestEntity: OpenAIRequestEntity):OpenAIResponseEntity{
        return openAIRepository.getOpenAIResponse(openAIRequestEntity)
    }
}