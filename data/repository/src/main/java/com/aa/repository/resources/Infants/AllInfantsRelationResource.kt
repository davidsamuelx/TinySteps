package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AllInfantsRelationResource(
    @SerializedName("Relations")
    val relations: List<InfantsRelationResource>?
)