package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class ProductByIdResource(
    @SerializedName("Products")
    val products: Products?
)