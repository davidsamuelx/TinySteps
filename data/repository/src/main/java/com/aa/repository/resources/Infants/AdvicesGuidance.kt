package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AdvicesGuidance(
    @SerializedName("advice_id")
    val adviceId: Int? = null,
    @SerializedName("Doctor Location")
    val doctorLocation: String? = null,
    @SerializedName("Doctor Name")
    val doctorName: String? = null,
    @SerializedName("Phone Doctor")
    val phoneDoctor: String? = null,
    @SerializedName("Profile Doctor")
    val profileDoctor: String? = null,
    @SerializedName("State")
    val state: String? = null
)