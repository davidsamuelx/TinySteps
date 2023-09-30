package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class NoteResource(
    @SerializedName("Note")
    val note: String? = null,
    @SerializedName("TDoctor")
    val tDoctor: String? = null,
    @SerializedName("TMedicine")
    val tMedicine: String? = null
)