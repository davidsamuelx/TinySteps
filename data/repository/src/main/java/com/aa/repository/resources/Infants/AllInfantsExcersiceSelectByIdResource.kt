package com.aa.repository.resources.Infants

import com.google.gson.annotations.SerializedName

data class AllInfantsExcersiceSelectByIdResource(
    @SerializedName("exercise")
    val exercise: InfantsExerciseResource?
)
