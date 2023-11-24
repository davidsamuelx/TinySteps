package com.aa.models.open_ai

data class OpenAIResponseEntity(
    val choices: List<Choice>,
    val created: Int,
    val id: String,
    val model: String,
    val object0: String
)

data class Choice(
    val finishReason: String,
    val index: Int,
    val text: String
)
