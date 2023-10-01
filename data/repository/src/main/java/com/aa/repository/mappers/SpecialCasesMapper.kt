package com.aa.repository.mappers


import com.aa.models.SpecialCaseEntity
import com.aa.repository.resources.SpecialCase
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun SpecialCase.toEntity(): SpecialCaseEntity{
    return SpecialCaseEntity(
        details=details.orEmpty(),
        iD=iD.orZero(),
        nameSpecialCase=nameSpecialCase.orEmpty(),
        pathImg=pathImg.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty()
    )
}