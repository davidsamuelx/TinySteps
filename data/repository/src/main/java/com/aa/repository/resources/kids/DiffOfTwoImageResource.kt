package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class DiffOfTwoImageResource(
    @SerializedName("Admin_id")
    val adminId: Int? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("HowManyDifference")
    val howManyDifference: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("PathImgOne")
    val pathImgOne: String? = null,
    @SerializedName("PathImgTwo")
    val pathImgTwo: String? = null,
    @SerializedName("PhaseThree_id")
    val phaseThreeId: Any? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("chooseOne")
    val chooseOne:Int?=null,
    @SerializedName("chooseTwo")
    val chooseTwo:Int?=null,
    @SerializedName("chooseThree")
    val chooseThree:Int?=null,
    @SerializedName("chooseFour")
    val chooseFour:Int?=null,
)