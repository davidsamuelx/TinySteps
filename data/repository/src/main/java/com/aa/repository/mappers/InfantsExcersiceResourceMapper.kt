package com.aa.repository.mappers

import com.aa.models.InfantsExcersiceEntity
import com.aa.repository.resources.Infants.InfantsExerciseResource
import com.aa.repository.utils.orZero

internal fun InfantsExerciseResource.toEntity():InfantsExcersiceEntity{
    return InfantsExcersiceEntity(
        createdAt=createdAt.orEmpty(),
        detailsEn=detailsEn.orEmpty(),
        id=id.orZero(),
        pathVideo=pathVideo.orEmpty(),
        updatedAt=updatedAt.orEmpty()
    )
}