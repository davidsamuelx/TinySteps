package com.aa.repository.resources.open_ai


import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("role")
    val role: String? = null
)