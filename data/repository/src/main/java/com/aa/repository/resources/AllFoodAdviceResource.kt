package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllFoodAdviceResource(
    @SerializedName("FoodBabies")
    val foodBabies: List<FoodBabyResource?>? = null
)