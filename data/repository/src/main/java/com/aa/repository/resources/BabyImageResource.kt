package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class BabyImageResource(
    @SerializedName("DevelopmentBaby")
    val developmentBaby: DevelopmentBaby? = null
)