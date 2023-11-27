package com.aa.models

data class ValidationResult(
    val isValid: Boolean,
    val errorMessage: String = ""
)