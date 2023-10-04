package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllBadHabitsResource(
    @SerializedName("badhabits")
    val badhabits: List<Badhabit?>? = null
)