package com.aa.remote

import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.AllMusicResource
import com.aa.repository.resources.AllVideosResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.MusicResource
import com.aa.repository.resources.VideoResource
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

    @GET("user/Pregnancy/exercises/getAllVideos")
    suspend fun getAllVideos():Response<AllVideosResource>

    @GET("user/Pregnancy/exercises/getVideo/{id}")
    suspend fun getVideoById(@Path("id") videoId: Int): Response<VideoResource>

    @GET("user/Pregnancy/exercises/SearchVideo/{searchName}")
    suspend fun searchVideoByName(@Path("searchName") searchName: String): Response<AllVideosResource>

    @GET("user/Pregnancy/exercises/getAllMusics")
    suspend fun getAllMusics():Response<AllMusicResource>

    @GET("user/Pregnancy/exercises/getMusic/{id}")
    suspend fun getMusicById(@Path("id") musicId: Int): Response<MusicResource>

    @GET("user/Pregnancy/exercises/SearchMusic/{musicType}")
    suspend fun searchMusicByType(@Path("musicType") musicType: String): Response<AllMusicResource>

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

}