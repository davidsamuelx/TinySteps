package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SearchBadHabitResourceItem(
    @SerializedName("Admin_id")
    val adminId: Int? = null,
    @SerializedName("advice_doctor_e_n")
    val adviceDoctorEN: AdviceDoctorEN? = null,
    @SerializedName("advice_id")
    val adviceId: Int? = null,
    @SerializedName("Details")
    val details: String? = null,
    @SerializedName("DocAdvice_id")
    val docAdviceId: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("NameBadHabit")
    val nameBadHabit: String? = null,
    @SerializedName("PathImg")
    val pathImg: String? = null
)