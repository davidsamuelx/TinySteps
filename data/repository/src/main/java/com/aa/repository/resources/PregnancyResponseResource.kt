package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class PregnancyResponseResource(
    @SerializedName("Differences")
    val differences: Differences? = Differences(),
    @SerializedName("links")
    val links: LinksX? = LinksX(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("newRecord")
    val newRecord: NewRecordX? = NewRecordX()
)