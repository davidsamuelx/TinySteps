package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllVideosResource(
    @SerializedName("videoResourceLists")
    val videoResourceLists: List<VideoResource?>? = null
)