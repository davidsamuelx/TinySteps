package com.aa.repository.mappers

import com.aa.models.kids.MathLandEntity
import com.aa.repository.resources.kids.MathLandResourceItem
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun MathLandResourceItem.toEntity():MathLandEntity{
    return MathLandEntity(
        id = id.orZero(),
        answer = answer.orEmpty(),
        levels = levels.orEmpty(),
        pathImg1 = pathImg1.orEmpty(),
        pathImg2 = pathImg2.orEmpty(),
        pathImg3 = pathImg3.orEmpty(),
        pathVoice = pathVoice.orEmpty(),
        title = title.orEmpty()
    )
}