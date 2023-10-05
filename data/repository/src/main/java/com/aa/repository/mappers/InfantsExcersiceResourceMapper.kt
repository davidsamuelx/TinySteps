package com.aa.repository.mappers

import com.aa.models.infants.InfantsExcersiceEntity
import com.aa.repository.resources.Infants.InfantsExerciseResource
import com.aa.repository.utils.orZero

internal fun InfantsExerciseResource?.toEntity(): InfantsExcersiceEntity {
    return InfantsExcersiceEntity(
        createdAt=this?.createdAt.orEmpty(),
        detailsEn=this?.detailsEn.orEmpty(),
        id=this?.id.orZero(),
        pathVideo=this?.pathVideo.orEmpty(),
        updatedAt=this?.updatedAt.orEmpty()
    )
}