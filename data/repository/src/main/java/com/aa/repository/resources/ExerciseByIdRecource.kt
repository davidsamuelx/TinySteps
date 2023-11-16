package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class ExerciseByIdRecource(
    @SerializedName("video")
    val video: VideoById? = VideoById()
)