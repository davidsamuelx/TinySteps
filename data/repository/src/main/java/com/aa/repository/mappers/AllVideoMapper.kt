package com.aa.repository.mappers

import com.aa.models.VideosEntity
import com.aa.repository.resources.Video
import com.aa.repository.utils.orZero

internal fun Video.toEntity(): VideosEntity{
    return VideosEntity(
        id = id.orZero(),
        videoUrl = videoPath.orEmpty(),
        videoName = videoNameEN.orEmpty(),
        videoDescription = videoDescriptionEN.orEmpty()
    )
}