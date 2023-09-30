package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class Advices(
    @SerializedName("advice_id")
    val adviceId: Int?,
    @SerializedName("Doctor Location")
    val doctorLocation: String?,
    @SerializedName("Doctor Name")
    val doctorName: String?,
    @SerializedName("Phone Doctor")
    val phoneDoctor: String?,
    @SerializedName("Profile Doctor")
    val profileDoctor: String?,
    @SerializedName("State")
    val state: String?
)