package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class RecordResource(
    @SerializedName("Games How Many Difference Of Images")
    val gamesHowManyDifferenceOfImages: String? = null,
    @SerializedName("Games Mathland")
    val gamesMathland: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("IsCorrect")
    val isCorrect: String? = null,
    @SerializedName("Levels")
    val levels: String? = null,
    @SerializedName("Title Of Game Puzzle Level One")
    val titleOfGamePuzzleLevelOne: String? = null,
    @SerializedName("Title Of Game Puzzle Level Three")
    val titleOfGamePuzzleLevelThree: String? = null,
    @SerializedName("Title Of Game Puzzle Level Two")
    val titleOfGamePuzzleLevelTwo: String? = null
)