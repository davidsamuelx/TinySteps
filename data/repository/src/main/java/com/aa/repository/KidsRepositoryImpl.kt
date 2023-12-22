package com.aa.repository

import com.aa.models.kids.AchievementsEntity
import com.aa.models.kids.AllStoriesEntity
import com.aa.models.kids.AnimalGameEntity
import com.aa.models.kids.DiffImageGameEntity
import com.aa.models.kids.EducationGameEntity
import com.aa.models.kids.KidsBadHabitEntity
import com.aa.models.kids.KidsFoodEntity
import com.aa.models.kids.KidsSpecialCaseEntity
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

    override suspend fun getAllStories(id: Int?, title: String?): List<AllStoriesEntity> {
        return remoteDataSource.getAllStories(id, title).storyphase3?.mapNotNull { it.toEntity() } ?: emptyList()
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

    override suspend fun getAllKidsFood(): List<KidsFoodEntity> {
        return remoteDataSource.getKidsFood().foodBabies
            ?.map { it.toEntity()  }?: emptyList()
    }

    override suspend fun selectKidsFood(id: Int): KidsFoodEntity {
        return remoteDataSource.getKidsSelectFood(id).foodBaby.toEntity()
    }

    override suspend fun searchKidsFood(food: String): List<KidsFoodEntity> {
        return remoteDataSource.getKidsSearchFood(food).foodBabies
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun getAllKidsBadHabits(): List<KidsBadHabitEntity> {
        return remoteDataSource.getKidsBadHabits().badhabits
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun selectKidsBadHabits(id: Int): KidsBadHabitEntity {
        return remoteDataSource.selectKidsBadHabits(id).badhabit.toEntity()
    }

    override suspend fun searchKidsBadHabits(badHabits: String): List<KidsBadHabitEntity> {
        return remoteDataSource.searchKidsBadHabits(badHabits).badhabits
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun getAllKidsSpecialCase(): List<KidsSpecialCaseEntity> {
        return remoteDataSource.getKidsSpecialCase().specialCases
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun selectKidsSpecialCase(id: Int): KidsSpecialCaseEntity {
        return remoteDataSource.selectKidsSpecialCase(id).specialCase.toEntity()
    }

    override suspend fun searchKidsSpecialCase(specialCase: String): List<KidsSpecialCaseEntity> {
        return remoteDataSource.searchKidsSpecialCase(specialCase).specialCases
            ?.map { it.toEntity() }?: emptyList()
    }


}