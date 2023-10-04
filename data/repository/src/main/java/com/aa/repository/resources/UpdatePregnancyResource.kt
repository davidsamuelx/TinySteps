package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class UpdatePregnancyResource(
    @SerializedName("Differences")
    val differences: Differences? = Differences(),
    @SerializedName("links")
    val links: LinksResource? = LinksResource(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("updatedRecord")
    val updatedRecord: UpdatedRecord? = UpdatedRecord()
)