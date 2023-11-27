package com.aa.repositories

import com.aa.models.open_ai.OpenAIRequestEntity
import com.aa.models.open_ai.OpenAIResponseEntity

interface OpenAIRepository {
    suspend fun getOpenAIResponse(
        openAIRequest: OpenAIRequestEntity
    ): OpenAIResponseEntity
}