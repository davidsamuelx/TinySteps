package com.aa.models.open_ai

data class OpenAIRequestEntity(
    val model : String,
    val message : List<Message>,
)

data class Message(
    val role : String,
    val content : String,
)
