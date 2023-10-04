package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class PregnancyResource(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("records")
    val records: List<Record?>? = null
)
