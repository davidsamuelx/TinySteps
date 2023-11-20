package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class FoodResource(
    @SerializedName("FoodBabies")
    val foodBabies: List<FoodBaby>? = listOf()
)