package com.aa.repository.datasources

import com.aa.repository.resources.AllBadHabitsResource
import com.aa.repository.resources.AllENSupportMessagesResource
import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.AllSpecialCaseResource
import com.aa.repository.resources.AllMusicResource
import com.aa.repository.resources.AllVideosResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.BadHabitByIdResource
import com.aa.repository.resources.ENImageResource
import com.aa.repository.resources.FoodByIdResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.NoteResource
import com.aa.repository.resources.NoteResponceResource
import com.aa.repository.resources.PregnancyResource
import com.aa.repository.resources.PregnancyResponseResource
import com.aa.repository.resources.PregnancyStoreResource
import com.aa.repository.resources.SearchBadHabitResource
import com.aa.repository.resources.SearchFoodResource
import com.aa.repository.resources.SearchedENSupportMessageResource
import com.aa.repository.resources.SelectedSupportMessageTypeResource
import com.aa.repository.resources.SupportMessageEnglishResource
import com.aa.repository.resources.TodayENSupportMessageResource
import com.aa.repository.resources.UpdatePregnancyResource
import com.aa.repository.resources.MusicResource
import com.aa.repository.resources.VideoResource

interface RemoteDataSource {

    suspend fun getFoodAdvices(): AllFoodAdviceResource
    suspend fun loginRequest(
        loginResource: LoginResource,
    ): LoginResponseResource

    suspend fun storeBabyGender(
        storeBabyGenderResource: StoreBabyGenderResource
    ): BabyGenderResource

    suspend fun deleteBabyGender(id: String)

    suspend fun updateBabyGender(id: String, babyGender: String)

    suspend fun addENSupportMessage(
        selectedSupportMessageTypeResource: SelectedSupportMessageTypeResource
    ): SupportMessageEnglishResource

    suspend fun getAllENSupportMessages(): AllENSupportMessagesResource

    suspend fun getENSupportMessageById(id: Int): SearchedENSupportMessageResource

    suspend fun deleteENSupportMessage(id: Int)

    suspend fun updateENSupportMessage(id: Int, messageType: String)

    suspend fun getImage(): ENImageResource

    suspend fun getTodaySupportMessage(): TodayENSupportMessageResource

    suspend fun addNote(noteResource: NoteResource): NoteResponceResource

    suspend fun getPregnancyData():PregnancyResource

    suspend fun addPregnancy(
        pregnancyStoreResource: PregnancyStoreResource
    ): PregnancyResponseResource

    suspend fun updatePregnancy(
        id: Int,
        startTime: String
    ):UpdatePregnancyResource

    suspend fun deletePregnancy(id: Int)

    suspend fun getAllBadHabit(): AllBadHabitsResource

    suspend fun getAllSpecialCases(): AllSpecialCaseResource

    suspend fun getFoodById(id:Int): FoodByIdResource

    suspend fun searchFood(foodSearch:String): SearchFoodResource

    suspend fun getAllBadHabitById(id:Int): BadHabitByIdResource

    suspend fun searchBadHabit(badHabit:String): SearchBadHabitResource


    suspend fun getAllVideos(): AllVideosResource

    suspend fun getVideoById(id: Int): VideoResource

    suspend fun getVideosByName(name: String): AllVideosResource

    suspend fun getAllMusics(): AllMusicResource

    suspend fun getMusicById(id: Int): MusicResource

    suspend fun getMusicByType(musicType: String): AllMusicResource
}