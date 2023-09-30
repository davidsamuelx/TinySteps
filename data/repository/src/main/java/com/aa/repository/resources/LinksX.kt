package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("delete")
    val delete: String? = null,
    @SerializedName("index")
    val index: String? = null,
    @SerializedName("main")
    val main: String? = null,
    @SerializedName("update")
    val update: String? = null
)