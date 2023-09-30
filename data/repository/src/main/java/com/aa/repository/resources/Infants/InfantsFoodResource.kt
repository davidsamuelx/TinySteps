package com.aa.repository.resources.Infants


import com.aa.repository.resources.Infants.AdvicesCase
import com.google.gson.annotations.SerializedName

data class InfantsFoodResource(
    @SerializedName("Advices")
    val advices: AdvicesCase?,
    @SerializedName("DetailsOfFood")
    val detailsOfFood: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("ImgFood")
    val imgFood: String?,
    @SerializedName("NameFood")
    val nameFood: String?
)