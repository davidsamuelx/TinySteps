package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Advices(
    @SerializedName("advice_id")
    val adviceId: Int? = null,
    @SerializedName("Doctor Location")
    val doctorLocation: String? = null,
    @SerializedName("Doctor Name")
    val doctorName: String? = null,
    @SerializedName("Name Problem")
    val nameProblem: String? = null,
    @SerializedName("Phone Doctor")
    val phoneDoctor: String? = null,
    @SerializedName("Problem Classification")
    val problemClassification: String? = null,
    @SerializedName("Profile Doctor")
    val profileDoctor: String? = null,
    @SerializedName("Solve Problem")
    val solveProblem: String? = null,
    @SerializedName("State")
    val state: String? = null
)