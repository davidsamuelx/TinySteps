package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllGuidanceInstructionResource(
    @SerializedName("GuidanceInstruction")
    val guidanceInstruction: List<GuidanceInstructionResource>?
)