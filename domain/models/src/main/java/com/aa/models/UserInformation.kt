package com.aa.models

data class UserInformation(
    val token : String ,
    val username :String ,
    val phases: String ,
    val gender: String ,
)
data class Token(
    val token: String,
    val expireTime: Long
)
