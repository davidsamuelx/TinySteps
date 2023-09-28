package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("confirm_password")
    val confirmPassword: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: Any? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("Phases")
    val phases: String? = null,
    @SerializedName("PhoneNumber")
    val phoneNumber: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("username")
    val username: String? = null
)