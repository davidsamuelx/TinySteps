package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsFoodResource(
    @SerializedName("FoodBabies")
    val foodBabies: List<InfantsFoodResource>?
)