package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class LoginResponseResource(
    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("expires_in")
    val expiresIn: Long? = null,
    @SerializedName("token_type")
    val tokenType: String? = null,
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("error")
    val error: String?,
    @SerializedName("password")
    val password: List<String?>?

)