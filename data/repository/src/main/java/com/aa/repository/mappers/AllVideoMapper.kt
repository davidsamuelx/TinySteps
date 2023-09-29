package com.aa.repository.mappers

import com.aa.models.VideosEntity
import com.aa.repository.resources.VideoResource
import com.aa.repository.utils.orZero
import com.aa.repository.utils.orEmpty

internal fun VideoResource.toEntity(): VideosEntity{
    return VideosEntity(
        id = id.orZero(),
        videoUrl = videoPath.orEmpty(),
        videoName = videoNameEN.orEmpty(),
        videoDescription = videoDescriptionEN.orEmpty()
    )
}