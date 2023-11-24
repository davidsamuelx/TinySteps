package com.aa.repository

import com.aa.models.open_ai.OpenAIRequestEntity
import com.aa.models.open_ai.OpenAIResponseEntity
import com.aa.repositories.OpenAIRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import com.aa.repository.mappers.toResource
import javax.inject.Inject

class OpenAIRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): OpenAIRepository {
    override suspend fun getOpenAIResponse(
        openAIRequest: OpenAIRequestEntity,
    ): OpenAIResponseEntity {
        return remoteDataSource.getOpenAIResponse(openAIRequest.toResource()).toEntity()
    }

}