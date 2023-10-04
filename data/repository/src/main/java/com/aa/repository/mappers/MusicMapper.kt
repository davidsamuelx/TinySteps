package com.aa.repository.mappers

import com.aa.models.MusicEntity
import com.aa.repository.resources.MusicResource
import com.aa.repository.utils.orZero
import com.aa.repository.utils.orEmpty

internal fun MusicResource.toEntity(): MusicEntity{
    return MusicEntity(
        id = id.orZero(),
        musicUrl = musicPath.orEmpty(),
        musicType = musicType.orEmpty(),
    )
}