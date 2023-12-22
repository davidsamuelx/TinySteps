package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class KidsFood(
    @SerializedName("FoodBabies")
    val foodBabies: List<FoodBaby?>?
)