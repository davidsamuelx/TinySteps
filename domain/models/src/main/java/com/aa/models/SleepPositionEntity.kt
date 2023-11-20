package com.aa.models

data class SleepPositionEntity(
    val id: Int,
    val nameOfPosition: String,
    val pathImg: String,
    val detailsOfPosition: String,
    val adviceId: Int,
    val doctorName: String,
    val phoneDoctor: String,
    val profileDoctor: String,
    val doctorLocation: String
)
