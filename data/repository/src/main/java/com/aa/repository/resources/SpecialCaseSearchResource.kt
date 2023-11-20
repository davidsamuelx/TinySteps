package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SpecialCaseSearchResource(
    @SerializedName("SpecialCases")
    val specialCases: List<SpecialCaseSearchItem>? = listOf()
)