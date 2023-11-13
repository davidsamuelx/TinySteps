package com.aa.repository.mappers

import com.aa.models.MusicEntity
import com.aa.repository.resources.Music
import com.aa.repository.resources.MusicResource
import com.aa.repository.utils.orZero
import com.aa.repository.utils.orEmpty

internal fun MusicResource.toEntity(): MusicEntity{
    return MusicEntity(
        id = id.orZero(),
        musicUrl = musicPath.orEmpty(),
        musicType = musicType.orEmpty(),
        imagePath = imgPath.orEmpty(),
    )
}

internal fun Music?.toEntity() : MusicEntity{
    return MusicEntity(
        id = this?.id.orZero(),
        musicUrl = this?.musicPath.orEmpty(),
        musicType = this?.musicType.orEmpty(),
        imagePath = this?.imgPath.orEmpty(),
    )
}