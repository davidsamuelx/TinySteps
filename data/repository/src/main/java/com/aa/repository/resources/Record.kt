package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("links")
    val links: Links? = null
)