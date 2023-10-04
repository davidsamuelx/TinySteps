package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsBadHabitsResource(
    @SerializedName("badhabits")
    val badhabits: List<InfantsBadhabitResource>?
)