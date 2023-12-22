package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class Badhabit(
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("Details")
    val details: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("NameBadHabit")
    val nameBadHabit: String?,
    @SerializedName("PathImg")
    val pathImg: String?
)