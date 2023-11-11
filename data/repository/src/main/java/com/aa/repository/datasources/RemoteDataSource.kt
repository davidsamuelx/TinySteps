package com.aa.repository.datasources

import com.aa.repository.resources.AllBadHabitsResource
import com.aa.repository.resources.AllENSupportMessagesResource
import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.Infants.AllGuidanceInstructionResource
import com.aa.repository.resources.Infants.AllGuidanceInstructionSelectResource
import com.aa.repository.resources.Infants.AllInfantsBadHabitsByIdResource
import com.aa.repository.resources.Infants.AllInfantsBadHabitsResource
import com.aa.repository.resources.Infants.AllInfantsExcersiceResource
import com.aa.repository.resources.Infants.AllInfantsExcersiceSearchResource
import com.aa.repository.resources.Infants.AllInfantsExcersiceSelectByIdResource
import com.aa.repository.resources.Infants.AllInfantsFoodByIdResource
import com.aa.repository.resources.Infants.AllInfantsFoodResource
import com.aa.repository.resources.Infants.AllInfantsProductsResource
import com.aa.repository.resources.Infants.AllInfantsProductsSelectResource
import com.aa.repository.resources.Infants.AllInfantsRelationByIdResource
import com.aa.repository.resources.Infants.AllInfantsRelationResource
import com.aa.repository.resources.Infants.AllInfantsSleepSelectResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseByIdResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseResource
import com.aa.repository.resources.Infants.InfantsSleepResource
import com.aa.repository.resources.AllSpecialCaseResource
import com.aa.repository.resources.AllMusicResource
import com.aa.repository.resources.AllVideosResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.BabyImageResource
import com.aa.repository.resources.BadHabitByIdResource
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
import com.aa.repository.resources.kids.AllAchievementsResource
import com.aa.repository.resources.kids.AllAnimalGameResource
import com.aa.repository.resources.kids.AllEducationGamesResource
import com.aa.repository.resources.kids.AllStoriesResource
import com.aa.repository.resources.kids.AnimalGameResource
import com.aa.repository.resources.kids.ImageDIfferenceGameResource
import com.aa.repository.resources.kids.LetterResource
import com.aa.repository.resources.kids.MathLandResource
import com.aa.repository.resources.kids.PuzzleGameResource

interface RemoteDataSource {

    suspend fun getFoodAdvices(): AllFoodAdviceResource

    //region phase 02 infants and Toddler
    suspend fun getGuidanceInstruction(): AllGuidanceInstructionResource
    suspend fun selectGuidanceInstruction(id:String):AllGuidanceInstructionSelectResource
    suspend fun searchGuidanceInstruction(id:String): AllGuidanceInstructionResource

    suspend fun getInfantsSleep(): InfantsSleepResource
    suspend fun selectInfantsSleep(id: Int):AllInfantsSleepSelectResource
    suspend fun searchInfantsSleep(id:String): InfantsSleepResource

    suspend fun getInfantsExcersice(): AllInfantsExcersiceResource
    suspend fun searchInfantsExcersice(videoPath:String):AllInfantsExcersiceSearchResource
    suspend fun selectByIdExcersice(id:Int):AllInfantsExcersiceSelectByIdResource

    suspend fun getInfantsRelation(): AllInfantsRelationResource
    suspend fun getInfantsRelationById(id:Int):AllInfantsRelationByIdResource
    suspend fun searchInfantsRelation(searchId:String):AllInfantsRelationResource

    suspend fun getInfantsBadHabits(): AllInfantsBadHabitsResource
    suspend fun getInfantsBadHabitsById(id:Int): AllInfantsBadHabitsByIdResource
    suspend fun searchInfantsBadHabits(badHabit:String): AllInfantsBadHabitsResource

    suspend fun getInfantsFood(): AllInfantsFoodResource
    suspend fun getInfantsFoodById(id:Int): AllInfantsFoodByIdResource
    suspend fun searchInfantsFood(foodSearch:String): AllInfantsFoodResource

    suspend fun getInfantsSpecialCase(): AllInfantsSpecialCaseResource
    suspend fun getInfantsSpecialCaseById(id: Int): AllInfantsSpecialCaseByIdResource
    suspend fun searchInfantsSpecialCase(specialSearch:String): AllInfantsSpecialCaseResource

    suspend fun getInfantsProducts():AllInfantsProductsResource
    suspend fun selectInfantsProducts(id: String):AllInfantsProductsSelectResource
    suspend fun searchInfantsProducts(product:String):AllInfantsProductsResource
 //endregion

    //region authentication
    suspend fun loginRequest(
        loginResource: LoginResource,
    ): LoginResponseResource

    //endregion

    //region pregnancy phase
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

    suspend fun getImage(id: Int): BabyImageResource

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

    //endregion

    suspend fun getMathLandGame(level: String): MathLandResource

    suspend fun getPuzzleGame(level: String):PuzzleGameResource

    suspend fun getDiffImageGame(): ImageDIfferenceGameResource

    suspend fun getAllStories(id: Int?,title: String?): AllStoriesResource

    suspend fun getAllAchievements(): AllAchievementsResource
    suspend fun getAnimalGame(): AllAnimalGameResource

    suspend fun getAnimalGameById(id: Int): AnimalGameResource

    suspend fun getEducationGame(): AllEducationGamesResource

    suspend fun getLetterById(id: Int): LetterResource
}