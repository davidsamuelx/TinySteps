package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Differences(
    @SerializedName("Days")
    val days: Int? = null,
    @SerializedName("Months")
    val months: Int? = null,
    @SerializedName("Weeks")
    val weeks: Int? = null
)