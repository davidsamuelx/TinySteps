package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsExcersiceSearchResource(
    @SerializedName("search_results")
    val searchResults: List<InfantsExerciseResource?>?
)