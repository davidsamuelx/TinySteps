package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Advice(
    @SerializedName("Details")
    val details: String? = null,
    @SerializedName("DoctorName")
    val doctorName: String? = null,
    @SerializedName("DoctorNum")
    val doctorNum: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("Location")
    val location: String? = null,
    @SerializedName("Path_img")
    val pathImg: String? = null
)