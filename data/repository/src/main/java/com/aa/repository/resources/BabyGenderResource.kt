package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class BabyGenderResource(
    @SerializedName("Kind Baby")
    val kindBaby: String? = null,
    @SerializedName("Message")
    val message: String? = null,
    @SerializedName("New Record")
    val newRecord: NewRecord? = null
)