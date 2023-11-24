package com.aa.repository.resources.open_ai


import com.google.gson.annotations.SerializedName

data class OpenAIRequestResource(
    @SerializedName("frequency_penalty")
    val frequencyPenalty: Int? = null,
    @SerializedName("max_tokens")
    val maxTokens: Int? = null,
    @SerializedName("messages")
    val messages: List<Message?>? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("n")
    val n: Int? = null,
    @SerializedName("presence_penalty")
    val presencePenalty: Int? = null,
    @SerializedName("stream")
    val stream: Boolean? = null,
    @SerializedName("temperature")
    val temperature: Int? = null,
    @SerializedName("top_p")
    val topP: Int? = null
)