package com.aa.repository.resources.Infants


import com.aa.repository.resources.Infants.Advices
import com.google.gson.annotations.SerializedName

data class SleepBabyResource(
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("details_ar")
    val detailsAr: String?,
    @SerializedName("details_en")
    val detailsEn: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("recommendedSleepHours")
    val recommendedSleepHours: String?
)