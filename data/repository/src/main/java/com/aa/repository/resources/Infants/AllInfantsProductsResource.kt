package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsProductsResource(
    @SerializedName("Products")
    val sleepBabies: List<InfantsProductsResource>?
)