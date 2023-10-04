package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class NoteRecord(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("Note")
    val note: String? = null,
    @SerializedName("TDoctor")
    val tDoctor: String? = null,
    @SerializedName("TMedicine")
    val tMedicine: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("user_id")
    val userId: Int? = null
)