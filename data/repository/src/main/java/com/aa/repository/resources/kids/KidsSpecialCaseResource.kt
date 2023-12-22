package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class KidsSpecialCaseResource(
    @SerializedName("SpecialCases")
    val specialCases: List<SpecialCase>?
)