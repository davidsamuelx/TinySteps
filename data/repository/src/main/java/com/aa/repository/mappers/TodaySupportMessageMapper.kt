package com.aa.repository.mappers

import com.aa.models.TodayENSupportMessageEntity
import com.aa.repository.resources.TodayENSupportMessageResource
import com.aa.repository.utils.orEmpty

internal fun TodayENSupportMessageResource.toEntity(): TodayENSupportMessageEntity{
    return TodayENSupportMessageEntity(
        message = message.orEmpty(),
    )
}