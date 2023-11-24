package com.aa.remote

import com.aa.repository.resources.open_ai.OpenAIRequestResource
import com.aa.repository.resources.open_ai.OpenAIResponseResource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAIService {

    //region openAi
    @POST("chat/completions")
    suspend fun getOpenAiResponse(
        @Body openAiRequest: OpenAIRequestResource
    ): Response<OpenAIResponseResource>
    //endregion
}