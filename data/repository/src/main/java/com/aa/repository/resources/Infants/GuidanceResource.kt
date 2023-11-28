package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class GuidanceResource(
    @SerializedName("GuidanceInstruction")
    val guidanceInstruction: List<GuidanceInstruction>? = listOf()
)