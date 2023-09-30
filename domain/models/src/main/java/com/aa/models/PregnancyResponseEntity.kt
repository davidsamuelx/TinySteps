package com.aa.models

data class PregnancyResponseEntity(
    val userId: Int,
    val startDate: String,
    val monthsDifference: Int,
    val weeksDifference: Int,
    val daysDifference: Int
)
