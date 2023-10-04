package com.aa.repository.mappers

import com.aa.models.ImageEntity
import com.aa.repository.resources.ENImageResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun ENImageResource.toEntity(): ImageEntity{
    return ImageEntity(
        imageUrl = pathImg.orEmpty(),
        details = detailsEN.orEmpty(),
        weekNumber = weekNumber.orZero()
    )
}
