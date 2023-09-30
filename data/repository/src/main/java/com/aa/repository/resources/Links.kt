package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("delete")
    val delete: String? = null,
    @SerializedName("self")
    val self: String? = null,
    @SerializedName("update")
    val update: String? = null
)