package com.aa.repository.mappers

import com.aa.models.InfantsSleepEntity
import com.aa.repository.resources.Infants.SleepBabyResource
import com.aa.repository.utils.orZero

internal fun SleepBabyResource.toEntity():InfantsSleepEntity{
    return InfantsSleepEntity(
        id = iD.orZero(),
        detailsEn=detailsEn.orEmpty(),
        recommendedSleepHours=recommendedSleepHours.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty()
    )

}