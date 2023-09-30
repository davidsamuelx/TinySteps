package com.aa.repository.resources.Infants


import com.aa.repository.resources.Infants.Advices
import com.google.gson.annotations.SerializedName

data class GuidanceInstructionResource(
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("details_ar")
    val detailsAr: String?,
    @SerializedName("details_en")
    val detailsEn: String?,
    @SerializedName("TitleAR")
    val titleAR: String?,
    @SerializedName("TitleEN")
    val titleEN: String?
)