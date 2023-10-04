package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class SelectedSupportMessageTypeResource(
    @SerializedName("SelectWhenSendSupportMessage")
    val selectWhenSendSupportMessage: String? = null
)