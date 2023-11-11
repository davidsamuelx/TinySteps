package com.aa.repository.mappers

import com.aa.models.ImageEntity
import com.aa.repository.resources.DevelopmentBaby
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun DevelopmentBaby?.toEntity(): ImageEntity{
    return ImageEntity(
        imageUrl = this?.pathImg.orEmpty(),
        details = this?.detailsEN.orEmpty(),
        weekNumber = this?.weekNumber.orZero(),
        id = this?.id.orZero()
    )
}
