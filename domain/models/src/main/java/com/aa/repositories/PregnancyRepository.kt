package com.aa.repositories

import com.aa.models.AllFoodAdviceEntity
import com.aa.models.BabyGenderEntity
import com.aa.models.MusicEntity
import com.aa.models.StoreBabyGenderEntity
import com.aa.models.VideosEntity

interface PregnancyRepository {

    suspend fun allFoodAdvice():List<AllFoodAdviceEntity>

    suspend fun storeBabyGender(storeBabyGenderEntity: StoreBabyGenderEntity):BabyGenderEntity

    suspend fun deleteBabyGender(id: String)

    suspend fun updateBabyGender( babyId: String, babyGender: String)

    suspend fun allVideos():List<VideosEntity>

    suspend fun getVideoById(id: Int): VideosEntity

    suspend fun getVideoByName(name: String): List<VideosEntity>

    suspend fun getAllMusics(): List<MusicEntity>

    suspend fun getMusicById(id: Int): MusicEntity

    suspend fun getMusicByType(musicType: String): List<MusicEntity>

}
