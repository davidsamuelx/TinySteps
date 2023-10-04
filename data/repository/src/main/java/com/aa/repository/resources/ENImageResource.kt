package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class ENImageResource(
    @SerializedName("DetailsEN")
    val detailsEN: String? = null,
    @SerializedName("path_img")
    val pathImg: String? = null,
    @SerializedName("WeekNumber")
    val weekNumber: Int? = null
)