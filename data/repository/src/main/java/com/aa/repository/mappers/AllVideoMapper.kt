package com.aa.repository.mappers

import com.aa.models.ExerciseEntity
import com.aa.repository.resources.ExerciseSearchResourceItem
import com.aa.repository.resources.Video
import com.aa.repository.resources.VideoById
import com.aa.repository.resources.VideoResource
import com.aa.repository.utils.orZero
import com.aa.repository.utils.orEmpty

internal fun Video.toEntity(): ExerciseEntity{
    return ExerciseEntity(
        id = id.orZero(),
        videoUrl = videoPath.orEmpty(),
        videoName = videoNameEN.orEmpty(),
        videoDescription = videoDescriptionEN.orEmpty(),
        imageUrl = imgPath.orEmpty()
    )
}


internal fun VideoById?.toEntity(): ExerciseEntity{
    return ExerciseEntity(
        id = this?.id.orZero(),
        videoUrl = this?.videoPath.orEmpty(),
        videoName = this?.videoNameEN.orEmpty(),
        videoDescription = this?.videoDescriptionEN.orEmpty(),
        imageUrl = this?.imgPath.orEmpty()
    )
}

internal fun ExerciseSearchResourceItem.toEntity(): ExerciseEntity{
    return ExerciseEntity(
        id = id.orZero(),
        videoUrl = videoPath.orEmpty(),
        videoName = videoNameEN.orEmpty(),
        videoDescription = videoDescriptionEN.orEmpty(),
        imageUrl = imgPath.orEmpty()
    )
}

internal fun VideoResource.toEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = id.orZero(),
        videoUrl = videoPath.orEmpty(),
        videoName = videoNameEN.orEmpty(),
        videoDescription = videoDescriptionEN.orEmpty(),
        imageUrl = ""
    )
}