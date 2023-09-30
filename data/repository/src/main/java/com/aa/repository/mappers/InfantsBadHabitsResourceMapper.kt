package com.aa.repository.mappers

import com.aa.models.InfantsBadHabitsEntity
import com.aa.repository.resources.Infants.InfantsBadhabitResource
import com.aa.repository.utils.orZero

internal fun InfantsBadhabitResource.toEntity():InfantsBadHabitsEntity{
    return InfantsBadHabitsEntity(
        details=details.orEmpty(),
        iD=iD.orZero(),
        nameBadHabit=nameBadHabit.orEmpty(),
        pathImg=pathImg.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty()
    )
}