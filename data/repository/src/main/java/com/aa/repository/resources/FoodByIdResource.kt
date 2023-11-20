package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class FoodByIdResource(
    @SerializedName("FoodBaby")
    val foodBaby: FoodBabyById? = FoodBabyById()
)