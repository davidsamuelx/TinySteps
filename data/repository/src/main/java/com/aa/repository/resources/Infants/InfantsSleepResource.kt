package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantsSleepResource(
    @SerializedName("SleepBabies")
    val sleepBabies: List<SleepBabyResource?>?
)