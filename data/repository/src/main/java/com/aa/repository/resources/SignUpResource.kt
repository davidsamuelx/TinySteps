package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SignUpResource(
    @SerializedName("AgeBaby")
    val ageBaby: Int?,
    @SerializedName("confirm_password")
    val confirmPassword: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("StartDate")
    val startDate: String?,
    @SerializedName("username")
    val username: String?
)