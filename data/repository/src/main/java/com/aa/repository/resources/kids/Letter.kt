package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class Letter(
    @SerializedName("Admin_id")
    val adminId: Any? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("letter")
    val letter: String? = null,
    @SerializedName("Levels")
    val levels: String? = null,
    @SerializedName("PhaseThree_id")
    val phaseThreeId: Any? = null,
    @SerializedName("sound")
    val sound: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)