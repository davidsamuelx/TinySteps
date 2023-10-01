package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SearchFoodResource(
    @SerializedName("FoodBabies")
    val foodBabies: List<FoodBaby>? = listOf()
)