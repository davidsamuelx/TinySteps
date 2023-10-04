package com.aa.repository.mappers

import com.aa.models.PregnancyEntity
import com.aa.models.PregnancyResponseEntity
import com.aa.models.PregnancyStoreEntity
import com.aa.models.UpdatePregnancyEntity
import com.aa.repository.resources.Data
import com.aa.repository.resources.PregnancyResponseResource
import com.aa.repository.resources.PregnancyStoreResource
import com.aa.repository.resources.UpdatePregnancyResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun Data.toEntity(): PregnancyEntity{
    return PregnancyEntity(
        userId = userId.orZero(),
        startDate = startDate.orEmpty(),
        nowDate = nowDate.orEmpty(),
        daysDifference = daysDifference.orZero(),
        weeksDifference = weeksDifference.orZero(),
        monthsDifference = monthsDifference.orZero()
    )
}

internal fun PregnancyStoreEntity.toResource(): PregnancyStoreResource{
    return PregnancyStoreResource(
        startDate = startDate.orEmpty()
    )
}

internal fun PregnancyResponseResource.toEntity(): PregnancyResponseEntity{
    return PregnancyResponseEntity(
        userId = newRecord?.userId.orZero(),
        startDate = newRecord?.startDate.orEmpty(),
        daysDifference = differences?.days.orZero(),
        weeksDifference = differences?.weeks.orZero(),
        monthsDifference = differences?.months.orZero()
    )
}

internal fun UpdatePregnancyResource.toEntity(): UpdatePregnancyEntity{
    return UpdatePregnancyEntity(
        userId = updatedRecord?.userId.orZero(),
        id = updatedRecord?.id.orZero(),
        startDate = updatedRecord?.startDate.orEmpty(),
        nowDate = updatedRecord?.nowDate.orEmpty(),
        daysDifference = differences?.days.orZero(),
        weeksDifference = differences?.weeks.orZero(),
        monthsDifference = differences?.months.orZero()
    )
}

