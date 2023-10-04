package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantsExerciseResource(
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("details_ar")
    val detailsAr: String?,
    @SerializedName("details_en")
    val detailsEn: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("path_video")
    val pathVideo: String?,
    @SerializedName("phase2_id")
    val phase2Id: Any?,
    @SerializedName("updated_at")
    val updatedAt: String?
)