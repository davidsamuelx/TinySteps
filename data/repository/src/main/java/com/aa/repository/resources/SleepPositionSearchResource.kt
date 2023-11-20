package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SleepPositionSearchResource(
    @SerializedName("responseData")
    val responseData: List<SleepPositionItemSearchResource>? = listOf()
)