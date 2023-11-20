package com.aa.repository.mappers

import com.aa.models.SleepPositionEntity
import com.aa.repository.resources.ResponseData
import com.aa.repository.resources.SleepPositionItemSearchResource
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

internal fun ResponseData?.toEntity(): SleepPositionEntity{
    return SleepPositionEntity(
        id = this?.iD.orZero(),
        nameOfPosition = this?.nameOfPosition.orEmpty(),
        pathImg = this?.pathImg.orEmpty(),
        detailsOfPosition = this?.detailsOfPosition.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
    )
}

internal fun SleepPositionItemSearchResource.toEntity(): SleepPositionEntity{
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