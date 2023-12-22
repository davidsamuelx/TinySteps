package com.aa.repository.mappers

import com.aa.models.kids.KidsBadHabitEntity
import com.aa.repository.resources.kids.Badhabit
import com.aa.repository.utils.orZero

internal fun Badhabit?.toEntity(): KidsBadHabitEntity {
    return KidsBadHabitEntity(
        details=this?.details.orEmpty(),
        iD=this?.iD.orZero(),
        nameBadHabit=this?.nameBadHabit.orEmpty(),
        pathImg=this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
    )
}