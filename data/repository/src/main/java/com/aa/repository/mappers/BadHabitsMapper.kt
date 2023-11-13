package com.aa.repository.mappers

import com.aa.models.BadHabitEntity
import com.aa.repository.resources.Badhabit
import com.aa.repository.resources.BadhabitByID
import com.aa.repository.resources.SearchBadHabitResourceItem
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun Badhabit?.toEntity(): BadHabitEntity{
    return BadHabitEntity(
        details = this?.details.orEmpty(),
        iD = this?.iD.orZero(),
        nameBadHabit = this?.nameBadHabit.orEmpty(),
        pathImg = this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
    )
}

internal fun SearchBadHabitResourceItem.toEntity(): BadHabitEntity{
    return BadHabitEntity(
        details=details.orEmpty(),
        iD=id.orZero(),
        nameBadHabit=nameBadHabit.orEmpty(),
        pathImg=pathImg.orEmpty(),
        adviceId = adviceId.orZero(),
        doctorName = adviceDoctorEN?.advice?.doctorName.orEmpty(),
        phoneDoctor = adviceDoctorEN?.advice?.doctorNum.orEmpty(),
        profileDoctor = adviceDoctorEN?.advice?.pathImg.orEmpty(),
        solveProblem = adviceDoctorEN?.solveProblemEN.orEmpty(),
        doctorLocation = adviceDoctorEN?.advice?.location.orEmpty()
    )
}

internal fun BadhabitByID?.toEntity(): BadHabitEntity{
    return BadHabitEntity(
        details = this?.details.orEmpty(),
        iD = this?.iD.orZero(),
        nameBadHabit = this?.nameBadHabit.orEmpty(),
        pathImg = this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
    )
}