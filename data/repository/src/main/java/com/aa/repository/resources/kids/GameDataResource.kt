package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class GameDataResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("sound")
    val sound: String? = null
)