package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class GameData(
    @SerializedName("Admin_id")
    val adminId: Any? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("PhaseThree_id")
    val phaseThreeId: Any? = null,
    @SerializedName("sound")
    val sound: String? = null
)