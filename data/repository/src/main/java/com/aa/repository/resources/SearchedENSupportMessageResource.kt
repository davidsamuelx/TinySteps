package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SearchedENSupportMessageResource(
    @SerializedName("Message")
    val message: String? = null,
    @SerializedName("Record")
    val searchedENRecord: SearchedENRecord? = null
)