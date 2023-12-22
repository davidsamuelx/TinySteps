package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class KidsSelectFood(
    @SerializedName("FoodBaby")
    val foodBaby: FoodBaby?
)