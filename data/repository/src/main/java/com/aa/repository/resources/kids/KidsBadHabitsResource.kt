package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class KidsBadHabitsResource(
    @SerializedName("badhabits")
    val badhabits: List<Badhabit>?
)