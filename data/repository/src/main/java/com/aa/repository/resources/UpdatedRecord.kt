package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class UpdatedRecord(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("DaysDifference")
    val daysDifference: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("monthsDifference")
    val monthsDifference: Int? = null,
    @SerializedName("NowDate")
    val nowDate: String? = null,
    @SerializedName("StartDate")
    val startDate: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("user_id")
    val userId: Int? = null,
    @SerializedName("weeksDifference")
    val weeksDifference: Int? = null
)