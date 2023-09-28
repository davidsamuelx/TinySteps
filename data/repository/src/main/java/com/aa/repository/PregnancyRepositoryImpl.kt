package com.aa.repository

import com.aa.models.AllFoodAdviceEntity
import com.aa.repositories.PregnancyRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import javax.inject.Inject

class PregnancyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
): PregnancyRepository {
    override suspend fun allFoodAdvice(): List<AllFoodAdviceEntity> {
        return remoteDataSource.getFoodAdvices().foodBabies
            ?.mapNotNull { it?.toEntity() } ?: emptyList()
    }
}