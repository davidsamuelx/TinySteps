package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class DevelopmentBaby(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("DetailsEN")
    val detailsEN: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("path_img")
    val pathImg: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("WeekNumber")
    val weekNumber: Int? = null
)