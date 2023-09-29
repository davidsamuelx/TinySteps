package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllVideosResource(
    @SerializedName("videoList")
    val videoList: List<Video?>? = null
)