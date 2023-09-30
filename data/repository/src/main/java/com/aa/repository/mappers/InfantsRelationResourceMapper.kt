package com.aa.repository.mappers

import com.aa.models.InfantsRelationEntity
import com.aa.repository.resources.Infants.InfantsRelationResource
import com.aa.repository.utils.orZero

internal fun InfantsRelationResource.toEntity():InfantsRelationEntity{
    return InfantsRelationEntity(
        advice= advice.orEmpty(),
        title=title.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty()
    )
}