package com.aa.repository.resources.Infants

import com.google.gson.annotations.SerializedName

data class AllInfantsRelationByIdResource(
    @SerializedName("Relation")
    val relations: InfantsRelationResource?
)
