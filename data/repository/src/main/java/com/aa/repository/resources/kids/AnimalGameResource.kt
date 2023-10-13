package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class AnimalGameResource(
    @SerializedName("game_data")
    val gameData: GameData? = null
)