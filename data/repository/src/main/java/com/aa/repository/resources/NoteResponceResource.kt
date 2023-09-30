package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class NoteResponceResource(
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("newRecord")
    val newRecord: NoteRecord? = NoteRecord()
)