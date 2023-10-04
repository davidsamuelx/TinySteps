package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Badhabit(
    @SerializedName("Advices")
    val advices: Advices? = null,
    @SerializedName("Details")
    val details: String? = null,
    @SerializedName("ID")
    val iD: Int? = null,
    @SerializedName("NameBadHabit")
    val nameBadHabit: String? = null,
    @SerializedName("PathImg")
    val pathImg: String? = null
)