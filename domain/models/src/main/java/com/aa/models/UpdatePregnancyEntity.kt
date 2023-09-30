package com.aa.models

data class UpdatePregnancyEntity (
    val userId: Int,
    val id: Int,
    val startDate: String,
    val nowDate: String,
    val monthsDifference: Int,
    val weeksDifference: Int,
    val daysDifference: Int
)