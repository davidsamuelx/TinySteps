package com.aa.repository.resources.Infants

import com.google.gson.annotations.SerializedName

data class AllInfantsSleepSelectResource(
    @SerializedName("SleepBaby")
    val SleepBaby:SleepBabyResource?
    ){
}