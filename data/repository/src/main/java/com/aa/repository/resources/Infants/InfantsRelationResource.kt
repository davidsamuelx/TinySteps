package com.aa.repository.resources.Infants


import com.aa.repository.resources.Infants.Advices
import com.google.gson.annotations.SerializedName

data class InfantsRelationResource(
    @SerializedName("Advice")
    val advice: String?,
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("Title")
    val title: String?
)