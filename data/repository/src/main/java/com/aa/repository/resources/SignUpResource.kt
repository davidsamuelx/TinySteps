package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SignUpResource(
    @SerializedName("AgeBaby")
    val ageBaby: Int? = null,
    @SerializedName("confirm_password")
    val confirmPassword: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("StartDate")
    val startDate: String? = null,
    @SerializedName("username")
    val username: String? = null
)