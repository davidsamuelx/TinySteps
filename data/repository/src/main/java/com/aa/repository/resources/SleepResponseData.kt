package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SleepResponseData(
    @SerializedName("Advices")
    val advices: SleepAdvices? = SleepAdvices(),
    @SerializedName("DetailsOfPosition")
    val detailsOfPosition: String? = "",
    @SerializedName("ID")
    val iD: Int? = 0,
    @SerializedName("NameOfPosition")
    val nameOfPosition: String? = "",
    @SerializedName("PathImg")
    val pathImg: String? = ""
)