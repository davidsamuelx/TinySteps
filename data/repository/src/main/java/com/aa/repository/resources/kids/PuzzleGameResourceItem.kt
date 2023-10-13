package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class PuzzleGameResourceItem(
    @SerializedName("Admin_id")
    val adminId: Int? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("Details")
    val details: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("Level")
    val level: String? = null,
    @SerializedName("OrderAnswer1")
    val orderAnswer1: String? = null,
    @SerializedName("OrderAnswer2")
    val orderAnswer2: String? = null,
    @SerializedName("OrderAnswer3")
    val orderAnswer3: String? = null,
    @SerializedName("OrderAnswer4")
    val orderAnswer4: String? = null,
    @SerializedName("OrderAnswer5")
    val orderAnswer5: String? = null,
    @SerializedName("OrderAnswer6")
    val orderAnswer6: String? = null,
    @SerializedName("PathImg1")
    val pathImg1: String? = null,
    @SerializedName("PathImg2")
    val pathImg2: String? = null,
    @SerializedName("PathImg3")
    val pathImg3: String? = null,
    @SerializedName("PathImg4")
    val pathImg4: String? = null,
    @SerializedName("PathImg5")
    val pathImg5: String? = null,
    @SerializedName("PathImg6")
    val pathImg6: String? = null,
    @SerializedName("PhaseThree_id")
    val phaseThreeId: Any? = null,
    @SerializedName("Title")
    val title: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)