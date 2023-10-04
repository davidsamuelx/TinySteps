package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class PregnancyStoreResource(
    @SerializedName("StartDate")
    val startDate: String? = null
)