package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class SelectSpecialCaseResource(
    @SerializedName("SpecialCase")
    val specialCase: SpecialCase?
)