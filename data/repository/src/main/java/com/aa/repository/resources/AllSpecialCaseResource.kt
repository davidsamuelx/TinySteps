package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllSpecialCaseResource(
    @SerializedName("specialCase")
    val specialCase: List<SpecialCase>? = listOf()
)