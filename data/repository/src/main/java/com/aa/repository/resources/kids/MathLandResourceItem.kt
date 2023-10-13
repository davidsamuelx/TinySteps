package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class MathLandResourceItem(
    @SerializedName("Admin_id")
    val adminId: Int? = null,
    @SerializedName("Answer")
    val answer: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("Levels")
    val levels: String? = null,
    @SerializedName("PathImg1")
    val pathImg1: String? = null,
    @SerializedName("PathImg2")
    val pathImg2: String? = null,
    @SerializedName("PathImg3")
    val pathImg3: String? = null,
    @SerializedName("PathVoice")
    val pathVoice: String? = null,
    @SerializedName("PhaseThree_id")
    val phaseThreeId: Any? = null,
    @SerializedName("Title")
    val title: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)