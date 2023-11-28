package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantExerciseSearchResult(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("details_ar")
    val detailsAr: String? = null,
    @SerializedName("details_en")
    val detailsEn: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("PathImg")
    val pathImg: String? = null,
    @SerializedName("path_video")
    val pathVideo: String? = null,
    @SerializedName("phase2_id")
    val phase2Id: Any? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)