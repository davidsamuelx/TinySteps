package com.aa.models

data class DiagnosisEntity(
    val name: String,
    val symptoms: List<String>,
    val cause: String,
    val treatment: List<String>,
    var percentage: Double = 0.0
)
