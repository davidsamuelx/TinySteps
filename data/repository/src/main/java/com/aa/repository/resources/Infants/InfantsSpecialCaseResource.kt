package com.aa.repository.resources.Infants


import com.aa.repository.resources.Infants.AdvicesCase
import com.google.gson.annotations.SerializedName

data class InfantsSpecialCaseResource(
    @SerializedName("Advices")
    val advices: AdvicesCase?,
    @SerializedName("Details")
    val details: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("NameSpecialCase")
    val nameSpecialCase: String?,
    @SerializedName("PathImg")
    val pathImg: String?
)