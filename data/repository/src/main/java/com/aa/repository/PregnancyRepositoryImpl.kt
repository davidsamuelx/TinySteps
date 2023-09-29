package com.aa.repository

import com.aa.models.AllFoodAdviceEntity
import com.aa.models.BabyGenderEntity
import com.aa.models.StoreBabyGenderEntity
import com.aa.models.VideosEntity
import com.aa.repositories.PregnancyRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import com.aa.repository.mappers.toResource
import javax.inject.Inject

class PregnancyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
): PregnancyRepository {
    override suspend fun allFoodAdvice(): List<AllFoodAdviceEntity> {
        return remoteDataSource.getFoodAdvices().foodBabies
            ?.mapNotNull { it?.toEntity() } ?: emptyList()
    }

    override suspend fun storeBabyGender(storeBabyGenderEntity: StoreBabyGenderEntity): BabyGenderEntity {
        return remoteDataSource.storeBabyGender(storeBabyGenderEntity.toResource()).toEntity()
    }

    override suspend fun deleteBabyGender(id: String) {
        return remoteDataSource.deleteBabyGender(id)
    }

    override suspend fun updateBabyGender( babyId: String, babyGender: String) {
        return remoteDataSource.updateBabyGender(
            id = babyId,
            babyGender = babyGender
        )
    }

    override suspend fun allVideos(): List<VideosEntity> {
        return remoteDataSource.getAllVideos().videoList
            ?.mapNotNull { it?.toEntity() } ?: emptyList()
    }

    override suspend fun getVideoById(id: Int): VideosEntity {
        return remoteDataSource.getVideoById(id).toEntity()
    }

    override suspend fun getVideoByName(name: String): List<VideosEntity> {
        return remoteDataSource.getVideosByName(name).videoList
            ?.mapNotNull { it?.toEntity() } ?: emptyList()
    }
}