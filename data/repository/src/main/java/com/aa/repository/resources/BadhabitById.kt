package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class BadhabitByID(
    @SerializedName("Advices")
    val advices: AdvicesBadHabit? = AdvicesBadHabit(),
    @SerializedName("Details")
    val details: String? = "",
    @SerializedName("ID")
    val iD: Int? = 0,
    @SerializedName("NameBadHabit")
    val nameBadHabit: String? = "",
    @SerializedName("PathImg")
    val pathImg: String? = ""
)