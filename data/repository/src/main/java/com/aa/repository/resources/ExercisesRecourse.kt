package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class ExercisesRecourse(
    @SerializedName("videoList")
    val videoList: List<Video?>? = null
)