package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SignUpResponseResource(
    @SerializedName("Details For Pregnancy")
    val detailsForPregnancy: DetailsForPregnancy?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("user")
    val user: UserX?
)