package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SupportMessageEnglishResource(
    @SerializedName("Message")
    val message: String? = "",
    @SerializedName("New ENRecord")
    val newRecord: SupportMessageEnNewRecord? = SupportMessageEnNewRecord(),
    @SerializedName("Select Times")
    val selectTimes: String? = ""
)