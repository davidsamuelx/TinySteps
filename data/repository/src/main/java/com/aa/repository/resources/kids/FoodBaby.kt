package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class FoodBaby(
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("DetailsOfFood")
    val detailsOfFood: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("ImgFood")
    val imgFood: String?,
    @SerializedName("NameFood")
    val nameFood: String?,
    @SerializedName("SpecificFood")
    val specificFood: String?
)