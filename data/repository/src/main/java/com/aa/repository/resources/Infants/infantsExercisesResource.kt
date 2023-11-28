package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class infantsExercisesResource(
    @SerializedName("exercises")
    val exercises: List<Exercise?>? = null
)