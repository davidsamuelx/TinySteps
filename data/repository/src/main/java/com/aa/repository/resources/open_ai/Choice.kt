package com.aa.repository.resources.open_ai


import com.google.gson.annotations.SerializedName

data class Choice(
    @SerializedName("finish_reason")
    val finishReason: String? = "",
    @SerializedName("index")
    val index: Int? = 0,
    @SerializedName("message")
    val message: Message? = Message()
)