package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class StoreBabyGenderResource(
    @SerializedName("kindBaby")
    val kindBaby: String? = null
)