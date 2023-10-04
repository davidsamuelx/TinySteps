package com.aa.repository.mappers

import com.aa.models.BabyGenderEntity
import com.aa.models.StoreBabyGenderEntity
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.utils.orZero

internal fun StoreBabyGenderEntity.toResource():StoreBabyGenderResource{
    return StoreBabyGenderResource(
        kindBaby = babyGender.orEmpty()
    )
}

internal fun BabyGenderResource.toEntity():BabyGenderEntity{
    return BabyGenderEntity(
        babyGender = kindBaby.orEmpty(),
        message = message.orEmpty(),
        preId = babyNewRecord?.preId.orZero(),
        id = babyNewRecord?.id.orZero(),
    )
}