package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsSpecialCaseResource(
    @SerializedName("SpecialCases")
    val specialCases: List<InfantsSpecialCaseResource>?
)