package com.aa.repository.mappers

import com.aa.models.open_ai.Message
import com.aa.models.open_ai.OpenAIRequestEntity
import com.aa.repository.resources.open_ai.OpenAIRequestResource

internal fun OpenAIRequestEntity.toResource(): OpenAIRequestResource {
    return OpenAIRequestResource(
        model = model,
        messages = message.map { it.toResource() }
    )
}

private fun Message.toResource(): com.aa.repository.resources.open_ai.Message {
    return com.aa.repository.resources.open_ai.Message(
        content = content,
        role = role
    )
}