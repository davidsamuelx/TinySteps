package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantExerciseByIdResource(
    @SerializedName("exercise")
    val exercise: ExerciseById? = ExerciseById()
)