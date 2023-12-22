package com.aa.repository.mappers

import com.aa.models.kids.EducationGameEntity
import com.aa.repository.resources.kids.ImagesData
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun ImagesData?.toEntity():EducationGameEntity{
    return EducationGameEntity(
        id = this?.id.orZero(),
        image = this?.image.orEmpty(),
        letter = this?.letter.orEmpty(),
        sound = this?.sound.orEmpty(),
        level = this?.levels.orEmpty()
    )
}