package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class LetterResource(
    @SerializedName("letter")
    val letter: Letter? = null
)