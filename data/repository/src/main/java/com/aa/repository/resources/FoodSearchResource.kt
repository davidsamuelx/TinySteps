package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class FoodSearchResource(
    @SerializedName("FoodBabies")
    val foodBabies: List<FoodBabySearch>? = listOf()
)