package com.aa.repository.mappers

import com.aa.models.infants.InfantsRelationEntity
import com.aa.repository.resources.Infants.InfantsRelationResource
import com.aa.repository.utils.orZero

internal fun InfantsRelationResource?.toEntity(): InfantsRelationEntity {
    return InfantsRelationEntity(
        advice= this?.advice.orEmpty(),
        title=this?.title.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty()
    )
}