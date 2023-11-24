package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("AgeBaby")
    val ageBaby: Int?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("StartDate")
    val startDate: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("username")
    val username: String?
)