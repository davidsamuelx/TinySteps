package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantsRelationResource(
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("Advice")
    val advice: String?,
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("Title")
    val title: String?
)