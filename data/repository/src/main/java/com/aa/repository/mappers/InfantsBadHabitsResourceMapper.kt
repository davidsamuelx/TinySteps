package com.aa.repository.mappers

import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.repository.resources.Infants.InfantsBadhabitResource
import com.aa.repository.utils.orZero

internal fun InfantsBadhabitResource?.toEntity(): InfantsBadHabitsEntity {
    return InfantsBadHabitsEntity(
        details=this?.details.orEmpty(),
        iD=this?.iD.orZero(),
        nameBadHabit=this?.nameBadHabit.orEmpty(),
        pathImg=this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty()
    )
}