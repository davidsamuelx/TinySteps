package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllMusicResource(
    @SerializedName("musicResourceList")
    val musicResourceList: List<MusicResource?>? = null
)