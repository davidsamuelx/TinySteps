package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class Storyphase3(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("PathVideo")
    val pathVideo: String? = null,
    @SerializedName("Title")
    val title: String? = null
)