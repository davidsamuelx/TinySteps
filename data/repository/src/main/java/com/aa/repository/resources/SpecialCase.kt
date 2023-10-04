package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SpecialCase(
    @SerializedName("Advices")
    val advices: Advices? = Advices(),
    @SerializedName("Details")
    val details: String? = "",
    @SerializedName("ID")
    val iD: Int? = 0,
    @SerializedName("NameSpecialCase")
    val nameSpecialCase: String? = "",
    @SerializedName("PathImg")
    val pathImg: String? = ""
)