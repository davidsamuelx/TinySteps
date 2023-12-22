package com.aa.repository.mappers

import com.aa.models.kids.KidsSpecialCaseEntity
import com.aa.repository.resources.kids.SpecialCase
import com.aa.repository.utils.orZero

internal fun SpecialCase?.toEntity(): KidsSpecialCaseEntity {
    return  KidsSpecialCaseEntity(
        details=this?.details.orEmpty(),
        iD=this?.iD.orZero(),
        nameSpecialCase=this?.nameSpecialCase.orEmpty(),
        pathImg=this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
    )
}