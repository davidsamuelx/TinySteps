package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class FoodBaby(
    @SerializedName("Advices")
    val advices: Advices? = Advices(),
    @SerializedName("DetailsOfFood")
    val detailsOfFood: String? = "",
    @SerializedName("ID")
    val iD: Int? = 0,
    @SerializedName("ImgFood")
    val imgFood: String? = "",
    @SerializedName("NameFood")
    val nameFood: String? = ""
)