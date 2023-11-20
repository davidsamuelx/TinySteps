package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SpecialCaseSearchItem(
    @SerializedName("Advices")
    val advices: AdvicesSpecialSearch? = AdvicesSpecialSearch(),
    @SerializedName("Details")
    val details: String? = "",
    @SerializedName("ID")
    val iD: Int? = 0,
    @SerializedName("NameSpecialCase")
    val nameSpecialCase: String? = "",
    @SerializedName("PathImg")
    val pathImg: String? = ""
)