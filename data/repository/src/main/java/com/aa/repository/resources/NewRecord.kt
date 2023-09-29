package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class NewRecord(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("kindBaby")
    val kindBaby: String? = null,
    @SerializedName("pre_id")
    val preId: Int? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)