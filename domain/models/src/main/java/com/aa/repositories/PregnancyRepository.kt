package com.aa.repositories

import com.aa.models.AddNoteEntity
import com.aa.models.AllFoodAdviceEntity
import com.aa.models.AllSupportMessagesEntity
import com.aa.models.BabyGenderEntity
import com.aa.models.BadHabitEntity
import com.aa.models.ExerciseEntity
import com.aa.models.ImageEntity
import com.aa.models.MusicEntity
import com.aa.models.NoteEntity
import com.aa.models.PregnancyEntity
import com.aa.models.PregnancyResponseEntity
import com.aa.models.PregnancyStoreEntity
import com.aa.models.SelectedSupportMessageEntity
import com.aa.models.SleepPositionEntity
import com.aa.models.SpecialCaseByIdEntity
import com.aa.models.SpecialCaseEntity
import com.aa.models.StoreBabyGenderEntity
import com.aa.models.SupportMessageEntity
import com.aa.models.TodayENSupportMessageEntity
import com.aa.models.UpdatePregnancyEntity

interface PregnancyRepository {

    suspend fun allFoodAdvice():List<AllFoodAdviceEntity>

    suspend fun storeBabyGender(storeBabyGenderEntity: StoreBabyGenderEntity):BabyGenderEntity

    suspend fun deleteBabyGender(id: String)

    suspend fun updateBabyGender( babyId: String, babyGender: String)

    suspend fun addENSupportMessage(
      selectedSupportMessageEntity: SelectedSupportMessageEntity
    ): SupportMessageEntity

    suspend fun allENSupportMessage(): List<AllSupportMessagesEntity>

    suspend fun getENSupportMessageById(id: Int): SupportMessageEntity

    suspend fun deleteEnSupportMessage(id: Int)

    suspend fun updateEnSupportMessage(messageId: Int, messageType: String)

    suspend fun getImage(id: Int): ImageEntity

    suspend fun getTodaySupportMessage(): TodayENSupportMessageEntity

    suspend fun addNote(addNoteEntity: AddNoteEntity): NoteEntity

    suspend fun getPregnancyData(): List<PregnancyEntity>

    suspend fun addPregnancy(
        pregnancyStoreEntity: PregnancyStoreEntity
    ): PregnancyResponseEntity

    suspend fun updatePregnancy(
        id: Int,
        startTime: String
    ):UpdatePregnancyEntity

    suspend fun deletePregnancy(id: Int)

    suspend fun getAllBadHabit(): List<BadHabitEntity>

    suspend fun getAllSpecialCases(): List<SpecialCaseEntity>

    suspend fun getFoodById(id:Int): AllFoodAdviceEntity

    suspend fun searchFood(foodSearch:String): List<AllFoodAdviceEntity>

    suspend fun getAllBadHabitById(id:Int): BadHabitEntity

    suspend fun searchBadHabit(badHabit:String): List<BadHabitEntity>

    suspend fun allVideos():List<ExerciseEntity>

    suspend fun getVideoById(id: Int): ExerciseEntity

    suspend fun getVideoByName(name: String): List<ExerciseEntity>

    suspend fun getAllMusics(): List<MusicEntity>

    suspend fun getMusicById(id: Int): MusicEntity

    suspend fun getMusicByType(musicType: String): List<MusicEntity>

    suspend fun getAllSleepPosition(): List<SleepPositionEntity>

    suspend fun getSleepPositionById(id: Int): SleepPositionEntity

    suspend fun getSpecialCaseById(id: Int): SpecialCaseByIdEntity

    suspend fun searchSpecialCase(specialCase: String): List<SpecialCaseEntity>

    suspend fun searchSleepPosition(sleepPosition: String): List<SleepPositionEntity>

}
