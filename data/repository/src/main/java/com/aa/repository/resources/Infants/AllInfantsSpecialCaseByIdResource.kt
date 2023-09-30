package com.aa.repository.resources.Infants

import com.google.gson.annotations.SerializedName

data class AllInfantsSpecialCaseByIdResource(
    @SerializedName("SpecialCase")
    val specialCase: InfantsSpecialCaseResource?
)
