package com.aa.repository.mappers

import com.aa.models.InfantsFoodEntity
import com.aa.repository.resources.Infants.InfantsFoodResource
import com.aa.repository.utils.orZero

internal fun InfantsFoodResource.toEntity():InfantsFoodEntity{
    return InfantsFoodEntity(
        detailsOfFood=detailsOfFood.orEmpty(),
        iD=iD.orZero(),
        imgFood=imgFood.orEmpty(),
        nameFood=nameFood.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty()
    )
}