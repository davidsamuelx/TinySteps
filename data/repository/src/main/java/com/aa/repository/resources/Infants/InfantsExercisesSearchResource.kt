package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantsExercisesSearchResource(
    @SerializedName("search_results")
    val infantExerciseSearchResults: List<InfantExerciseSearchResult?>? = null
)