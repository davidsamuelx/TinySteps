package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsProductsSelectResource(
    @SerializedName("Product")
    val product: InfantsProductsResource?
)