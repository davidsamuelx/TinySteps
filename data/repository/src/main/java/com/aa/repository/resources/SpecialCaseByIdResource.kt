package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SpecialCaseByIdResource(
    @SerializedName("SpecialCase")
    val specialCase: SpecialCaseById? = SpecialCaseById()
)