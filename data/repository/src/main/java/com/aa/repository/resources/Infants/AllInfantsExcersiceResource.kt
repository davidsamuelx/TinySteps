package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsExcersiceResource(
    @SerializedName("exercises")
    val exercises: List<InfantsExerciseResource?>?
)