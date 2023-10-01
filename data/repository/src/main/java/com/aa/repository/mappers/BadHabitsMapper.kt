package com.aa.repository.mappers

import com.aa.models.BadHabitEntity
import com.aa.repository.resources.Badhabit
import com.aa.repository.resources.SearchBadHabitResourceItem
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun Badhabit.toEntity(): BadHabitEntity{
    return BadHabitEntity(
        details = details.orEmpty(),
        iD = iD.orZero(),
        nameBadHabit = nameBadHabit.orEmpty(),
        pathImg = pathImg.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty()
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
        solveProblem = adviceDoctorEN?.solveProblemEN.orEmpty()
    )
}