package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class MusicByIdResource(
    @SerializedName("music")
    val music: Music? = null
)