package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class SpecialCase(
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("Details")
    val details: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("NameSpecialCase")
    val nameSpecialCase: String?,
    @SerializedName("PathImg")
    val pathImg: String?
)