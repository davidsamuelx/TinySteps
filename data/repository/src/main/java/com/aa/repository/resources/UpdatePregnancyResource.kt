package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class UpdatePregnancyResource(
    @SerializedName("Differences")
    val differences: DifferencesX? = DifferencesX(),
    @SerializedName("links")
    val links: LinksXX? = LinksXX(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("updatedRecord")
    val updatedRecord: UpdatedRecord? = UpdatedRecord()
)