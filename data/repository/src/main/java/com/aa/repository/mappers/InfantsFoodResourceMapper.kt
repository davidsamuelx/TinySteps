package com.aa.repository.mappers

import com.aa.models.infants.InfantsFoodEntity
import com.aa.repository.resources.Infants.InfantsFoodResource
import com.aa.repository.utils.orZero

internal fun InfantsFoodResource?.toEntity(): InfantsFoodEntity {
    return InfantsFoodEntity(
        detailsOfFood=this?.detailsOfFood.orEmpty(),
        iD=this?.iD.orZero(),
        imgFood=this?.imgFood.orEmpty(),
        nameFood=this?.nameFood.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty()
    )
}