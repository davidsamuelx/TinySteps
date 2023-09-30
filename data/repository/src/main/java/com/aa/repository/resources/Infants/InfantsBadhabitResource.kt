package com.aa.repository.resources.Infants


import com.aa.repository.resources.Infants.AdvicesCase
import com.google.gson.annotations.SerializedName

data class InfantsBadhabitResource(
    @SerializedName("Advices")
    val advices: AdvicesCase?,
    @SerializedName("Details")
    val details: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("NameBadHabit")
    val nameBadHabit: String?,
    @SerializedName("PathImg")
    val pathImg: String?
)