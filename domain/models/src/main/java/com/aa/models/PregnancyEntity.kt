package com.aa.models

data class PregnancyEntity(
    val userId: Int,
    val startDate: String,
    val nowDate: String,
    val monthsDifference: Int,
    val weeksDifference: Int,
    val daysDifference: Int
)
