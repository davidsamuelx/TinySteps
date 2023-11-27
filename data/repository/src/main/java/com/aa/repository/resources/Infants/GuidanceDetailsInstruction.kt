package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class GuidanceDetailsInstruction(
    @SerializedName("Advices")
    val advices: AdvicesGuidanceDetails? = AdvicesGuidanceDetails(),
    @SerializedName("details_ar")
    val detailsAr: String? = "",
    @SerializedName("details_en")
    val detailsEn: String? = "",
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("PathImg")
    val pathImg: String? = "",
    @SerializedName("TitleAR")
    val titleAR: String? = "",
    @SerializedName("TitleEN")
    val titleEN: String? = ""
)