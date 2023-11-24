package com.aa.repository.resources.open_ai


import com.google.gson.annotations.SerializedName

data class OpenAIResponseResource(
    @SerializedName("choices")
    val choices: List<Choice>? = listOf(),
    @SerializedName("created")
    val created: Int? = 0,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("model")
    val model: String? = "",
    @SerializedName("object")
    val objectX: String? = "",
    @SerializedName("usage")
    val usage: Usage? = Usage()
)