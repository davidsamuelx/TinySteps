package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AdviceDoctorEN(
    @SerializedName("advice")
    val advice: Advice? = null,
    @SerializedName("advice_id")
    val adviceId: Int? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("NameProblem_EN")
    val nameProblemEN: String? = null,
    @SerializedName("phaseTwo_ID")
    val phaseTwoID: Any? = null,
    @SerializedName("pre_id")
    val preId: Any? = null,
    @SerializedName("ProblemClassification")
    val problemClassification: String? = null,
    @SerializedName("SolveProblem_EN")
    val solveProblemEN: String? = null,
    @SerializedName("State")
    val state: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)