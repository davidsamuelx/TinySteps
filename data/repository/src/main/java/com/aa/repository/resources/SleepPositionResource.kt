package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SleepPositionResource(
    @SerializedName("responseData")
    val responseData: List<SleepResponseData>? = listOf()
)