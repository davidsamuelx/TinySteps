package com.aa.repository

import com.aa.models.kids.AchievementsEntity
import com.aa.models.kids.AllStoriesEntity
import com.aa.models.kids.AnimalGameEntity
import com.aa.models.kids.DiffImageGameEntity
import com.aa.models.kids.EducationGameEntity
import com.aa.models.kids.LetterEntity
import com.aa.models.kids.MathLandEntity
import com.aa.models.kids.PuzzleGameEntity
import com.aa.repositories.KidsRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import javax.inject.Inject

class KidsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : KidsRepository {
    override suspend fun getMathLand(level: String): List<MathLandEntity> {
        return remoteDataSource.getMathLandGame(level).mapNotNull { it.toEntity() }
    }

    override suspend fun getPuzzleGame(level: String): List<PuzzleGameEntity> {
        return remoteDataSource.getPuzzleGame(level).mapNotNull { it.toEntity() }
    }

    override suspend fun getDiffImageGame(): List<DiffImageGameEntity> {
        return remoteDataSource.getDiffImageGame().diffOfTwoImages?.mapNotNull { it.toEntity() }
            ?: emptyList()
    }

    override suspend fun getAllStories(): List<AllStoriesEntity> {
        return remoteDataSource.getAllStories().storyphase3?.mapNotNull { it.toEntity() } ?: emptyList()
    }

    override suspend fun getAllAchievements(): List<AchievementsEntity> {
        return remoteDataSource.getAllAchievements().recordList?.mapNotNull { it.toEntity() } ?: emptyList()
    }

    override suspend fun getAnimalGame(): List<AnimalGameEntity> {
        return remoteDataSource.getAnimalGame().imagesData?.mapNotNull { it.toEntity() } ?: emptyList()
    }

    override suspend fun getAnimalGameById(id: Int): AnimalGameEntity {
        return remoteDataSource.getAnimalGameById(id).gameData.toEntity()
    }

    override suspend fun getEducationGame(): List<EducationGameEntity> {
        return remoteDataSource.getEducationGame().imagesData?.mapNotNull { it.toEntity() } ?: emptyList()
    }

    override suspend fun getLetterById(id: Int): LetterEntity {
        return remoteDataSource.getLetterById(id).letter.toEntity()
    }
}