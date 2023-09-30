package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class InfantsProductsResource(
    @SerializedName("Advices")
    val advices: Advices?,
    @SerializedName("Details_AR")
    val detailsAR: String?,
    @SerializedName("Details_EN")
    val detailsEN: String?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("NameProduct_AR")
    val nameProductAR: String?,
    @SerializedName("NameProduct_EN")
    val nameProductEN: String?,
    @SerializedName("Path_img")
    val pathImg: String?
)