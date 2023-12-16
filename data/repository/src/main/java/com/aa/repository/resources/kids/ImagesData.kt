package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class ImagesData(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("letter")
    val letter: String? = null,
    @SerializedName("sound")
    val sound: String? = null,
    @SerializedName("Levels")
    val levels:String?=null
)