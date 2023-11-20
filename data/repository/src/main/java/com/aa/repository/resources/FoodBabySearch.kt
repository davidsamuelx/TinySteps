package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class FoodBabySearch(
    @SerializedName("Advices")
    val advices: AdvicesFoodSearch? = AdvicesFoodSearch(),
    @SerializedName("DetailsOfFood")
    val detailsOfFood: String? = "",
    @SerializedName("ID")
    val iD: Int? = 0,
    @SerializedName("ImgFood")
    val imgFood: String? = "",
    @SerializedName("NameFood")
    val nameFood: String? = "",
    @SerializedName("SpecificFood")
    val specificFood: String? = ""
)