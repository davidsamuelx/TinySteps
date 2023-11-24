package com.aa.repository.mappers

import com.aa.models.open_ai.OpenAIResponseEntity
import com.aa.repository.resources.open_ai.Choice
import com.aa.repository.resources.open_ai.OpenAIResponseResource
import com.aa.repository.utils.orZero

internal fun OpenAIResponseResource.toEntity(): OpenAIResponseEntity{
    return OpenAIResponseEntity(
        choices = choices?.map { it.toEntity() }.orEmpty(),
        created = created.orZero(),
        id = id.orEmpty(),
        model = model.orEmpty(),
        object0 = objectX.orEmpty()
    )
}

private fun Choice.toEntity(): com.aa.models.open_ai.Choice {
    return com.aa.models.open_ai.Choice(
        finishReason = finishReason.orEmpty(),
        index = index.orZero(),
        text = message?.content.orEmpty()
    )
}