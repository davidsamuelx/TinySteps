package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class TodayENSupportMessageResource(
    @SerializedName("message")
    val message: String? = null
)