package com.aa.repositories

import com.aa.models.kids.AchievementsEntity
import com.aa.models.kids.AllStoriesEntity
import com.aa.models.kids.AnimalGameEntity
import com.aa.models.kids.DiffImageGameEntity
import com.aa.models.kids.EducationGameEntity
import com.aa.models.kids.LetterEntity
import com.aa.models.kids.MathLandEntity
import com.aa.models.kids.PuzzleGameEntity

interface KidsRepository {

    suspend fun getMathLand(level: String): List<MathLandEntity>

    suspend fun getPuzzleGame(level: String):List<PuzzleGameEntity>

    suspend fun getDiffImageGame(): List<DiffImageGameEntity>

    suspend fun getAllStories(id: Int?,title: String?): List<AllStoriesEntity>

    suspend fun getAllAchievements(): List<AchievementsEntity>

    suspend fun getAnimalGame(): List<AnimalGameEntity>

    suspend fun getAnimalGameById(id: Int):AnimalGameEntity

    suspend fun getEducationGame(): List<EducationGameEntity>

    suspend fun getLetterById(id: Int):LetterEntity

}