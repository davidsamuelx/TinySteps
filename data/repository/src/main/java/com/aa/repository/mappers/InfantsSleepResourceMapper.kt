package com.aa.repository.mappers

import com.aa.models.infants.InfantsSleepEntity
import com.aa.repository.resources.Infants.SleepBabyResource
import com.aa.repository.utils.orZero

internal fun SleepBabyResource?.toEntity(): InfantsSleepEntity {
    return InfantsSleepEntity(
        id = this?.iD.orZero(),
        detailsEn=this?.detailsEn.orEmpty(),
        recommendedSleepHours=this?.recommendedSleepHours.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor =this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty()
    )

}