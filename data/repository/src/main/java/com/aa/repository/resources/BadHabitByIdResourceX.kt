package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class BadHabitByIdResource(
    @SerializedName("badhabit")
    val badhabit: BadhabitByID? = BadhabitByID()
)