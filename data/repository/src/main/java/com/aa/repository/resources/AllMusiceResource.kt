package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllMusiceResource(
    @SerializedName("musicList")
    val musicList: List<MusicResource?>? = null
)