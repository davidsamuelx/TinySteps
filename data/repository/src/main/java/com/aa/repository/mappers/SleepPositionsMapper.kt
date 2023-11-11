package com.aa.repository.mappers

import com.aa.models.SleepPositionEntity
import com.aa.repository.resources.SleepResponseData
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun SleepResponseData.toEntity(): SleepPositionEntity{
    return SleepPositionEntity(
        id = iD.orZero(),
        nameOfPosition = nameOfPosition.orEmpty(),
        pathImg = pathImg.orEmpty(),
        detailsOfPosition = detailsOfPosition.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty(),
        doctorLocation = advices?.doctorLocation.orEmpty(),
    )
}