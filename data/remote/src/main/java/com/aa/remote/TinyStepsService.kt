package com.aa.remote

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
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TinyStepsService {

    //region authentication
    @GET("user/getData/Phase01/all-food")
    suspend fun getFoodAdvices():Response<FoodResource>
    //endregion

    //region pregnancy phase
    @GET("user/Pregnancy/exercises/getAllVideos")
    suspend fun getAllVideos():Response<ExercisesRecourse>

    @GET("user/Pregnancy/exercises/getVideo/{id}")
    suspend fun getVideoById(@Path("id") videoId: Int): Response<ExerciseByIdRecource>

    @GET("user/Pregnancy/exercises/SearchVideo/{searchName}")
    suspend fun searchVideoByName(@Path("searchName") searchName: String): Response<ExerciseSearchResource>

    @GET("user/Pregnancy/exercises/getAllMusics")
    suspend fun getAllMusics():Response<AllMusiceResource>

    @GET("user/Pregnancy/exercises/getMusic/{id}")
    suspend fun getMusicById(@Path("id") musicId: Int): Response<MusicByIdResource>

    @GET("user/Pregnancy/exercises/SearchMusic/{musicType}")
    suspend fun searchMusicByType(@Path("musicType") musicType: String): Response<AllMusiceResource>

    @POST("auth/user/login")
    suspend fun loginRequest(
        @Body loginResource: LoginResource
    ):Response<LoginResponseResource>

    @POST("auth/user/register")
    suspend fun signupRequest(
        @Body loginResource: SignUpResource
    ):Response<SignUpResponseResource>

    @POST("user/Pregnancy/BabyKind/store")
    suspend fun storeBabyGender(@Body babyGender: StoreBabyGenderResource): Response<BabyGenderResource>

    @DELETE("user/Pregnancy/BabyKind/Delete/{id}")
    suspend fun deleteBabyGender(@Path("id") babyId: String): Response<Unit>

    @FormUrlEncoded
    @PUT("user/Pregnancy/BabyKind/Update/{id}")
    suspend fun updateBabyGender(
        @Path("id") babyId: String,
        @Field("kindBaby") babyGender: String
    ): Response<Unit>

    @POST("user/Pregnancy/SelectWhenSendSupportMessageEnglish/store")
    suspend fun addSupportMessageEnglish(
        @Body supportMassageType: SelectedSupportMessageTypeResource
    ): Response<SupportMessageEnglishResource>

    @GET("user/Pregnancy/SelectWhenSendSupportMessageEnglish/Index")
    suspend fun getAllENSupportMessage(): Response<AllENSupportMessagesResource>

    @GET("user/Pregnancy/SelectWhenSendSupportMessageEnglish/show/{id}")
    suspend fun getENSupportMessageById(@Path("id") messageId: Int): Response<SearchedENSupportMessageResource>

    @DELETE("user/Pregnancy/SelectWhenSendSupportMessageEnglish/destroy/{id}")
    suspend fun deleteENSupportMessage(@Path("id") messageId: Int): Response<Unit>

    @FormUrlEncoded
    @PUT("user/Pregnancy/SelectWhenSendSupportMessageEnglish/update/{id}")
    suspend fun updateENSupportMessage(
        @Path("id") messageId: Int,
        @Field("SelectWhenSendSupportMessage") selectWhenSendSupportMessage: String
    ): Response<Unit>

    @GET("user/Pregnancy/DevelopBaby/getById")
    suspend fun getBabyImageById(@Query("id") id: Int): Response<BabyImageResource>

    @GET("user/Pregnancy/SupportMessageEnglish/Index")
    suspend fun getTodaySupportMessage(): Response<TodayENSupportMessageResource>

    @POST("user/Pregnancy/Note/store")
    suspend fun addNote(
        @Body noteResource: NoteResource
    ): Response<NoteResponceResource>

    @GET("user/Pregnancy/Main")
    suspend fun getPregnancyData(): Response<PregnancyResource>

    @POST("user/Pregnancy/PregnancyStore")
    suspend fun addPregnancy(
        @Body pregnancyStoreResource: PregnancyStoreResource
    ): Response<PregnancyResponseResource>

    @FormUrlEncoded
    @PUT("user/Pregnancy/Update/1")
    suspend fun updatePregnancy(
        @Path("id") userId: Int,
        @Field("StartDate") startDate: String
    ): Response<UpdatePregnancyResource>

    @DELETE("user/Pregnancy/Delete/{id}")
    suspend fun deletePregnancy(
        @Path("id") id: Int,
    ): Response<Unit>

    @GET("user/getData/Phase01/BadHabit/all")
    suspend fun getBadHabit(): Response<AllBadHabitsResource>

    @GET("user/getData/special-cases/phase01")
    suspend fun getSpecialCases(): Response<AllSpecialCaseResource>

    @GET("user/getData/Phase01/food/getById")
    suspend fun getFoodById(@Query("id")id: Int):Response<FoodByIdResource>

    @GET("user/getData/Phase01/search-food/{food_search}")
    suspend fun searchFood(@Path("food_search")foodSearch:String):Response<FoodSearchResource>

    @GET("user/getData/Phase01/BadHabit/getById")
    suspend fun getBadHabitsById(@Query("id") id:Int):Response<BadHabitByIdResource>

    @GET("user/Pregnancy/Advices/search-badhabits/{bad_habit}")
    suspend fun searchBadHabits(@Path("bad_habit")badHabit:String):Response<SearchBadHabitResource>

    @GET("user/Pregnancy/advice-sleep-positions/GetAll")
    suspend fun getSleepPositions(): Response<SleepPositionResource>

    @GET("user/Pregnancy/advice-sleep-positions/Get/{id}")
    suspend fun getSleepPositionsById(
        @Path("id") id: Int
    ): Response<SleepByIdResource>

    @GET("user/getData/special-cases/phase01/getById")
    suspend fun getSpecialCaseById(
        @Query("id") id: Int
    ):Response<SpecialCaseByIdResource>

    @GET("user/getData/special-cases/phase01/search/{special_case}")
    suspend fun searchSpecialCase(@Path("special_case")specialCase:String):Response<SpecialCaseSearchResource>

    @GET("user/Pregnancy/advice-sleep-positions/search/{sleep_position}")
    suspend fun searchSleepPositions(@Path("sleep_position")sleepPosition:String): Response<SleepPositionSearchResource>


    //endregion

    //region phase 02 infants and Toddler
    @GET("user/phase2/guidance-instructions/getAll")
    suspend fun getGuidanceAdvice():Response<GuidanceResource>

    @GET("user/phase2/guidance-instructions/Select/{select_id}")
    suspend fun selectGuidanceAdvice(@Path("select_id")selectId:Int):Response<GuidanceDetailsResource>

    @GET("user/phase2/guidance-instructions/search/{search_id}")
    suspend fun searchGuidanceAdvice(@Path("search_id") searchId:String):Response<AllGuidanceInstructionResource>

    @GET("user/phase2/Sleep/getAll")
    suspend fun getInfantsSleep():Response<InfantsSleepResource>

    @GET("user/phase2/Sleep/select/{select_id}")
    suspend fun selectInfantsSleep(@Path("select_id")sleepId:Int):Response<AllInfantsSleepSelectResource>

    @GET("user/phase2/Sleep/search/{search_id}")
    suspend fun searchInfantsSleep(@Path("search_id") searchId:String):Response<InfantsSleepResource>

    @GET("user/phase2/exercises/Index")
    suspend fun getInfantsExcersice():Response<infantsExercisesResource>

    @GET("user/phase2/exercises/searchVideo/{video_path}")
    suspend fun searchInfantsExcersice(@Path("video_path") videoPath:String):Response<InfantsExercisesSearchResource>

    @GET("user/phase2/exercises/getById/{select_id}")
    suspend fun selectByIdInfantsExcersie(@Path("select_id")selectId:Int):Response<InfantExerciseByIdResource>

    @GET("user/phase2/Relation/all")
    suspend fun getInfantsRelation():Response<AllInfantsRelationResource>

    @GET("user/phase2/Relation/selectById")
    suspend fun getInfantsRelationById(@Query("id") id:Int):Response<AllInfantsRelationByIdResource>

    @GET("user/phase2/Relation/search/{search_id}")
    suspend fun searchInfantsRelation(@Path("search_id") searchId:String):Response<AllInfantsRelationResource>

    @GET("user/getData/Phase02/BadHabit/all")
    suspend fun getInfantsBadHabits():Response<AllInfantsBadHabitsResource>

    @GET("user/getData/Phase02/BadHabit/getbyid")
    suspend fun getInfantsBadHabitsById(@Query("id") id:Int):Response<AllInfantsBadHabitsByIdResource>

    @GET("user/getData/Phase02/BadHabit/search/{bad_habit}")
    suspend fun searchInfantsBadHabits(@Path("bad_habit")badHabit:String):Response<AllInfantsBadHabitsResource>

    @GET("user/getData/Phase02/all-food")
    suspend fun getInfantsFood():Response<AllInfantsFoodResource>

    @GET("user/getData/Phase02/food/GetById")
    suspend fun getInfantsFoodById(@Query("id")id: Int):Response<AllInfantsFoodByIdResource>

    @GET("user/getData/Phase02/search-food/{food_search}")
    suspend fun searchInfantsFood(@Path("food_search")foodSearch:String):Response<AllInfantsFoodResource>

    @GET("user/getData/special-cases/phase02/GetAll")
    suspend fun getInfantsSpecialCase():Response<AllInfantsSpecialCaseResource>

    @GET("user/getData/special-cases/phase02/GetById")
    suspend fun getInfantsSpecialCaseById(@Query("id")id: Int):Response<AllInfantsSpecialCaseByIdResource>

    @GET("user/getData/special-cases/phase02/search/{special_search}")
    suspend fun searchInfantsSpecialCase(@Path("special_search")specialSearch:String):Response<AllInfantsSpecialCaseResource>

    @GET("user/phase2/products/AllProducts")
    suspend fun getInfantsProducts():Response<AllInfantsProductsResource>

    @GET("user/phase2/products/select")
    suspend fun selectInfantsProducts(@Query("id")id:String):Response<ProductByIdResource>

    @GET("user/phase2/products/search/{product}")
    suspend fun searchInfantsProducts(@Path("product")product:String):Response<AllInfantsProductsResource>

    //endregion

    //region phase 03
    @GET("user/Phase03/Getmathland/")
    suspend fun getMathLandGame(@Query("Levels") levels: String):Response<MathLandResource>

    @GET("user/Phase03/Getpuzzle/")
    suspend fun getPuzzleGame(@Query("Levels") levels: String):Response<PuzzleGameResource>

    @GET("user/Phase03/GetAll/diff-images")
    suspend fun getDiffImageGame():Response<ImageDIfferenceGameResource>

    @GET("user/Phase03/story/getall")
    suspend fun getAllStories(@Query("id") id: Int?,@Query("Title") title: String?):Response<AllStoriesResource>

    @GET("user/Phase03/Achievements/GetAll")
    suspend fun getAllAchievements():Response<AllAchievementsResource>

    @GET("user/Phase03/Animal/getAll")
    suspend fun getAnimalGame():Response<AllAnimalGameResource>

    @GET("user/Phase03/Animal/get-row-data/{id}")
    suspend fun getAnimalGameById(@Path("id") id:Int):Response<AnimalGameResource>

    @GET("education/Letters/getAll")
    suspend fun getEducationGame():Response<AllEducationGamesResource>

    @GET("education/letters/ShowLetter/{id}")
    suspend fun getLetterById(@Path("id") id:Int):Response<LetterResource>

    @GET("user/getData/Phase03/all-food")
    suspend fun getAllKidsFood():Response<KidsFood>

    @GET("user/getData/Phase03/food")
    suspend fun selectKidsFood(@Query("id")id:Int?):Response<KidsSelectFood>

    @GET("user/getData/Phase03/search-food")
    suspend fun searchKidsFood(@Query("search")search:String):Response<KidsFood>

    @GET("user/getData/Phase03/BadHabit/all")
    suspend fun getKidsBadHabits():Response<KidsBadHabitsResource>

    @GET("user/getData/Phase03/BadHabit/Select")
    suspend fun selectKidsBadHabit(@Query("id")id:Int?):Response<SelectKidsBadHabitsRsource>

    @GET("user/getData/Phase03/BadHabit/search")
    suspend fun searchKidsBadHabit(@Query("search")search:String):Response<KidsBadHabitsResource>

    @GET("user/getData/special-cases/phase03/getall")
    suspend fun  getKidsSpecialCase():Response<KidsSpecialCaseResource>

    @GET("user/getData/special-cases/phase03/select")
    suspend fun  selectKidsSpecialCase(@Query("id")id:Int):Response<SelectSpecialCaseResource>

    @GET("user/getData/special-cases/phase03/search")
    suspend fun searchKidsSpecialCase(@Query("search")search:String):Response<KidsSpecialCaseResource>


    //endregion

}