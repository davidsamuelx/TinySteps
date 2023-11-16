package com.aa.repository.mappers


import com.aa.models.SpecialCaseByIdEntity
import com.aa.models.SpecialCaseEntity
import com.aa.repository.resources.SpecialCase
import com.aa.repository.resources.SpecialCaseById
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

internal fun SpecialCaseById?.toEntity(): SpecialCaseByIdEntity{
    return SpecialCaseByIdEntity(
        details= this?.details.orEmpty(),
        iD= this?.iD.orZero(),
        nameSpecialCase= this?.nameSpecialCase.orEmpty(),
        pathImg= this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
    )
}