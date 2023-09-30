package com.aa.repository.resources.Infants


import com.google.gson.annotations.SerializedName

data class AdvicesCase(
    @SerializedName("advice_id")
    val adviceId: Int?,
    @SerializedName("Doctor Location")
    val doctorLocation: String?,
    @SerializedName("Doctor Name")
    val doctorName: String?,
    @SerializedName("Name Problem")
    val nameProblem: String?,
    @SerializedName("Phone Doctor")
    val phoneDoctor: String?,
    @SerializedName("Problem Classification")
    val problemClassification: String?,
    @SerializedName("Profile Doctor")
    val profileDoctor: String?,
    @SerializedName("Solve Problem")
    val solveProblem: String?,
    @SerializedName("State")
    val state: String?
)