package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class DetailsForPregnancy(
    @SerializedName("daysDifference")
    val daysDifference: Int?,
    @SerializedName("monthsDifference")
    val monthsDifference: Int?,
    @SerializedName("weeksDifference")
    val weeksDifference: Int?
)