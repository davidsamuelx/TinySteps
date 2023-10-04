package com.aa.repository.resources.Infants

import com.google.gson.annotations.SerializedName

data class AllInfantsFoodByIdResource(
    @SerializedName("FoodBaby")
    val foodBaby: InfantsFoodResource?
)
