package com.aa.repository.mappers

import com.aa.models.kids.AllStoriesEntity
import com.aa.repository.resources.kids.StoryResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun StoryResource?.toEntity():AllStoriesEntity{
    return AllStoriesEntity(
        id = this?.id.orZero(),
        pathVideo = this?.pathVideo.orEmpty(),
        title = this?.title.orEmpty()
    )
}