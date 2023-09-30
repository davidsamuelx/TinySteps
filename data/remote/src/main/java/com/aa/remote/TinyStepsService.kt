package com.aa.remote

import com.aa.repository.resources.NoteResource
import com.aa.repository.resources.AllENSupportMessagesResource
import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.ENImageResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.NoteResponceResource
import com.aa.repository.resources.SearchedENSupportMessageResource
import com.aa.repository.resources.SelectedSupportMessageTypeResource
import com.aa.repository.resources.SupportMessageEnglishResource
import com.aa.repository.resources.TodayENSupportMessageResource
import com.aa.repository.resources.PregnancyResource
import com.aa.repository.resources.PregnancyResponseResource
import com.aa.repository.resources.PregnancyStoreResource
import com.aa.repository.resources.UpdatePregnancyResource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TinyStepsService {
    @GET("user/getData/Phase01/all-food")
    suspend fun getFoodAdvices():Response<AllFoodAdviceResource>

    @POST("auth/user/login")
    suspend fun loginRequest(
        @Body loginResource: LoginResource
    ):Response<LoginResponseResource>

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

    @GET("user/Pregnancy/DevelopBabyEnglish/Index")
    suspend fun getENImage(): Response<ENImageResource>

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
    suspend fun getBadHabit(): Response<Unit>

    @GET("user/getData/special-cases/phase01")
    suspend fun getSpecialCases(): Response<Unit>



}