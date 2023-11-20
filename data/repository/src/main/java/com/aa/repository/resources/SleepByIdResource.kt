package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SleepByIdResource(
    @SerializedName("responseData")
    val responseData: ResponseData? = ResponseData()
)