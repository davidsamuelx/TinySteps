package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class PregnancyResponseResource(
    @SerializedName("Differences")
    val differences: Differences? = Differences(),
    @SerializedName("links")
    val links: LinksResource? = LinksResource(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("babyNewRecord")
    val newRecord: NewRecord? = NewRecord()
)