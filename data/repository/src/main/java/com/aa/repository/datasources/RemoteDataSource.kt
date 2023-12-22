package com.aa.repository.datasources

import com.aa.repository.resources.AllBadHabitsResource
import com.aa.repository.resources.AllENSupportMessagesResource
import com.aa.repository.resources.AllMusiceResource
import com.aa.repository.resources.AllSpecialCaseResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.BabyImageResource
import com.aa.repository.resources.BadHabitByIdResource
import com.aa.repository.resources.ExerciseByIdRecource
import com.aa.repository.resources.ExerciseSearchResource
import com.aa.repository.resources.ExercisesRecourse
import com.aa.repository.resources.FoodByIdResource
import com.aa.repository.resources.FoodResource
import com.aa.repository.resources.FoodSearchResource
import com.aa.repository.resources.Infants.AllGuidanceInstructionResource
import com.aa.repository.resources.Infants.AllInfantsBadHabitsByIdResource
import com.aa.repository.resources.Infants.AllInfantsBadHabitsResource
import com.aa.repository.resources.Infants.AllInfantsFoodByIdResource
import com.aa.repository.resources.Infants.AllInfantsFoodResource
import com.aa.repository.resources.Infants.AllInfantsProductsResource
import com.aa.repository.resources.Infants.AllInfantsRelationByIdResource
import com.aa.repository.resources.Infants.AllInfantsRelationResource
import com.aa.repository.resources.Infants.AllInfantsSleepSelectResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseByIdResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseResource
import com.aa.repository.resources.Infants.GuidanceDetailsResource
import com.aa.repository.resources.Infants.GuidanceResource
import com.aa.repository.resources.Infants.InfantExerciseByIdResource
import com.aa.repository.resources.Infants.InfantsExercisesSearchResource
import com.aa.repository.resources.Infants.InfantsSleepResource
import com.aa.repository.resources.Infants.ProductByIdResource
import com.aa.repository.resources.Infants.infantsExercisesResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.MusicByIdResource
import com.aa.repository.resources.NoteResource
import com.aa.repository.resources.NoteResponceResource
import com.aa.repository.resources.PregnancyResource
import com.aa.repository.resources.PregnancyResponseResource
import com.aa.repository.resources.PregnancyStoreResource
import com.aa.repository.resources.SearchBadHabitResource
import com.aa.repository.resources.SearchedENSupportMessageResource
import com.aa.repository.resources.SelectedSupportMessageTypeResource
import com.aa.repository.resources.SignUpResource
import com.aa.repository.resources.SignUpResponseResource
import com.aa.repository.resources.SleepByIdResource
import com.aa.repository.resources.SleepPositionResource
import com.aa.repository.resources.SleepPositionSearchResource
import com.aa.repository.resources.SpecialCaseByIdResource
import com.aa.repository.resources.SpecialCaseSearchResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.SupportMessageEnglishResource
import com.aa.repository.resources.TodayENSupportMessageResource
import com.aa.repository.resources.UpdatePregnancyResource
import com.aa.repository.resources.kids.AllAchievementsResource
import com.aa.repository.resources.kids.AllAnimalGameResource
import com.aa.repository.resources.kids.AllEducationGamesResource
import com.aa.repository.resources.kids.AllStoriesResource
import com.aa.repository.resources.kids.AnimalGameResource
import com.aa.repository.resources.kids.ImageDIfferenceGameResource
import com.aa.repository.resources.kids.KidsBadHabitsResource
import com.aa.repository.resources.kids.KidsFood
import com.aa.repository.resources.kids.KidsSelectFood
import com.aa.repository.resources.kids.KidsSpecialCaseResource
import com.aa.repository.resources.kids.LetterResource
import com.aa.repository.resources.kids.MathLandResource
import com.aa.repository.resources.kids.PuzzleGameResource
import com.aa.repository.resources.kids.SelectKidsBadHabitsRsource
import com.aa.repository.resources.kids.SelectSpecialCaseResource
import com.aa.repository.resources.open_ai.OpenAIRequestResource
import com.aa.repository.resources.open_ai.OpenAIResponseResource

interface RemoteDataSource {

    suspend fun getOpenAIResponse(
        openAIRequest: OpenAIRequestResource,
    ): OpenAIResponseResource

    suspend fun getFoodAdvices(): FoodResource

    //region phase 02 infants and Toddler
    suspend fun getGuidanceInstruction(): GuidanceResource
    suspend fun selectGuidanceInstruction(id:Int):GuidanceDetailsResource
    suspend fun searchGuidanceInstruction(id:String): AllGuidanceInstructionResource

    suspend fun getInfantsSleep(): InfantsSleepResource
    suspend fun selectInfantsSleep(id: Int): AllInfantsSleepSelectResource
    suspend fun searchInfantsSleep(id: String): InfantsSleepResource

    suspend fun getInfantsExercise(): infantsExercisesResource
    suspend fun searchInfantsExercise(videoPath:String):InfantsExercisesSearchResource
    suspend fun selectByIdExercise(id:Int):InfantExerciseByIdResource

    suspend fun getInfantsRelation(): AllInfantsRelationResource
    suspend fun getInfantsRelationById(id: Int): AllInfantsRelationByIdResource
    suspend fun searchInfantsRelation(searchId: String): AllInfantsRelationResource

    suspend fun getInfantsBadHabits(): AllInfantsBadHabitsResource
    suspend fun getInfantsBadHabitsById(id: Int): AllInfantsBadHabitsByIdResource
    suspend fun searchInfantsBadHabits(badHabit: String): AllInfantsBadHabitsResource

    suspend fun getInfantsFood(): AllInfantsFoodResource
    suspend fun getInfantsFoodById(id: Int): AllInfantsFoodByIdResource
    suspend fun searchInfantsFood(foodSearch: String): AllInfantsFoodResource

    suspend fun getInfantsSpecialCase(): AllInfantsSpecialCaseResource
    suspend fun getInfantsSpecialCaseById(id: Int): AllInfantsSpecialCaseByIdResource
    suspend fun searchInfantsSpecialCase(specialSearch: String): AllInfantsSpecialCaseResource

    suspend fun getInfantsProducts():AllInfantsProductsResource
    suspend fun selectInfantsProducts(id: String): ProductByIdResource
    suspend fun searchInfantsProducts(product:String):AllInfantsProductsResource
 //endregion

    //region authentication
    suspend fun loginRequest(
        loginResource: LoginResource,
    ): LoginResponseResource

    suspend fun signupRequest(
        signUpResource: SignUpResource
    ):SignUpResponseResource
    //endregion

    //region pregnancy phase
    suspend fun storeBabyGender(
        storeBabyGenderResource: StoreBabyGenderResource,
    ): BabyGenderResource

    suspend fun deleteBabyGender(id: String)

    suspend fun updateBabyGender(id: String, babyGender: String)

    suspend fun addENSupportMessage(
        selectedSupportMessageTypeResource: SelectedSupportMessageTypeResource,
    ): SupportMessageEnglishResource

    suspend fun getAllENSupportMessages(): AllENSupportMessagesResource

    suspend fun getENSupportMessageById(id: Int): SearchedENSupportMessageResource

    suspend fun deleteENSupportMessage(id: Int)

    suspend fun updateENSupportMessage(id: Int, messageType: String)

    suspend fun getImage(id: Int): BabyImageResource

    suspend fun getTodaySupportMessage(): TodayENSupportMessageResource

    suspend fun addNote(noteResource: NoteResource): NoteResponceResource

    suspend fun getPregnancyData(): PregnancyResource

    suspend fun addPregnancy(
        pregnancyStoreResource: PregnancyStoreResource,
    ): PregnancyResponseResource

    suspend fun updatePregnancy(
        id: Int,
        startTime: String,
    ): UpdatePregnancyResource

    suspend fun deletePregnancy(id: Int)

    suspend fun getAllBadHabit(): AllBadHabitsResource

    suspend fun getAllSpecialCases(): AllSpecialCaseResource

    suspend fun getFoodById(id: Int): FoodByIdResource

    suspend fun searchFood(foodSearch: String): FoodSearchResource

    suspend fun getAllBadHabitById(id: Int): BadHabitByIdResource

    suspend fun searchBadHabit(badHabit: String): SearchBadHabitResource


    suspend fun getAllVideos(): ExercisesRecourse

    suspend fun getVideoById(id: Int): ExerciseByIdRecource

    suspend fun getVideosByName(name: String): ExerciseSearchResource

    suspend fun getAllMusics(): AllMusiceResource

    suspend fun getMusicById(id: Int): MusicByIdResource

    suspend fun getMusicByType(musicType: String): AllMusiceResource

    suspend fun getAllSleepPosition(): SleepPositionResource

    suspend fun getSleepPositionById(id: Int): SleepByIdResource

    suspend fun getSpecialCaseById(id: Int): SpecialCaseByIdResource

    suspend fun searchSpecialCase(specialCase: String): SpecialCaseSearchResource

    suspend fun searchSleepPosition(sleepPosition: String): SleepPositionSearchResource

    //endregion

    suspend fun getMathLandGame(level: String): MathLandResource

    suspend fun getPuzzleGame(level: String): PuzzleGameResource

    suspend fun getDiffImageGame(): ImageDIfferenceGameResource

    suspend fun getAllStories(): AllStoriesResource

    suspend fun getAllAchievements(): AllAchievementsResource
    suspend fun getAnimalGame(): AllAnimalGameResource

    suspend fun getAnimalGameById(id: Int): AnimalGameResource

    suspend fun getEducationGame(): AllEducationGamesResource

    suspend fun getLetterById(id: Int): LetterResource

    suspend fun getKidsFood():KidsFood

    suspend fun getKidsSelectFood(id:Int):KidsSelectFood

    suspend fun getKidsSearchFood(food:String):KidsFood

    suspend fun getKidsBadHabits():KidsBadHabitsResource

    suspend fun selectKidsBadHabits(id:Int):SelectKidsBadHabitsRsource

    suspend fun searchKidsBadHabits(badHabits:String):KidsBadHabitsResource

    suspend fun getKidsSpecialCase():KidsSpecialCaseResource

    suspend fun selectKidsSpecialCase(id:Int):SelectSpecialCaseResource

    suspend fun searchKidsSpecialCase(specialCase:String):KidsSpecialCaseResource
}