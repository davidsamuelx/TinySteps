package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class LoginResource(
    @SerializedName("identifier")
    val identifier: String? = null,
    @SerializedName("password")
    val password: String? = null
)