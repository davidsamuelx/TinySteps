package com.aa.models

data class UserSignUpAuth(
    val name: String,
    val email: String,
    val password: String,
    val pregnancyDate: String,
    val age: Int,
    val confirm: String,
)
