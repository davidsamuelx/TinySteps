package com.aa.remote

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
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TinyStepsService {
    @GET("user/getData/Phase01/all-food")
    suspend fun getFoodAdvices():Response<AllFoodAdviceResource>

    //region phase 02 infants and Toddler
    @GET("user/phase2/guidance-instructions/getAll")
    suspend fun getGuidanceAdvice():Response<AllGuidanceInstructionResource>

    @GET("user/phase2/guidance-instructions/Select/{select_id}")
    suspend fun selectGuidanceAdvice(@Path("select_id")selectId:String):Response<AllGuidanceInstructionSelectResource>

    @GET("user/phase2/guidance-instructions/search/{search_id}")
    suspend fun searchGuidanceAdvice(@Path("search_id") searchId:String):Response<AllGuidanceInstructionResource>

    @GET("user/phase2/Sleep/getAll")
    suspend fun getInfantsSleep():Response<InfantsSleepResource>

    @GET("user/phase2/Sleep/select/{select_id}")
    suspend fun selectInfantsSleep(@Path("select_id")sleepId:Int):Response<AllInfantsSleepSelectResource>

    @GET("user/phase2/Sleep/search/{search_id}")
    suspend fun searchInfantsSleep(@Path("search_id") searchId:String):Response<InfantsSleepResource>

    @GET("user/phase2/exercises/Index")
    suspend fun getInfantsExcersice():Response<AllInfantsExcersiceResource>

    @GET("user/phase2/exercises/searchVideo/{video_path}")
    suspend fun searchInfantsExcersice(@Path("video_path") videoPath:String):Response<AllInfantsExcersiceSearchResource>

    @GET("user/phase2/exercises/getById/{select_id}")
    suspend fun selectByIdInfantsExcersie(@Path("select_id")selectId:Int):Response<AllInfantsExcersiceSelectByIdResource>

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
    suspend fun selectInfantsProducts(@Query("id")id:String):Response<AllInfantsProductsSelectResource>

    @GET("user/phase2/products/search/{product}")
    suspend fun searchInfantsProducts(@Path("product")product:String):Response<AllInfantsProductsResource>

    //endregion

    @POST("auth/user/login")
    suspend fun loginRequest(
        @Body loginResource: LoginResource
    ):Response<LoginResponseResource>

}