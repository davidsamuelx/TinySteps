package com.aa.repository.mappers

import com.aa.models.InfantsSpecialCaseEntity
import com.aa.repository.resources.Infants.InfantsSpecialCaseResource
import com.aa.repository.utils.orZero

internal fun InfantsSpecialCaseResource.toEntity():InfantsSpecialCaseEntity{
    return  InfantsSpecialCaseEntity(
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