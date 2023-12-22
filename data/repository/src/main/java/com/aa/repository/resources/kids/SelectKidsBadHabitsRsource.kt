package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class SelectKidsBadHabitsRsource(
    @SerializedName("badhabit")
    val badhabit: Badhabit?
)