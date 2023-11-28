package com.aa.repository.mappers

import com.aa.models.infants.InfantsExerciseEntity
import com.aa.repository.resources.Infants.Exercise
import com.aa.repository.resources.Infants.ExerciseById
import com.aa.repository.resources.Infants.InfantExerciseSearchResult
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun Exercise?.toEntity(): InfantsExerciseEntity {
    return InfantsExerciseEntity(
        createdAt=this?.createdAt.orEmpty(),
        detailsEn=this?.detailsEn.orEmpty(),
        id=this?.id.orZero(),
        pathVideo=this?.pathVideo.orEmpty(),
        updatedAt=this?.updatedAt.orEmpty(),
        name = this?.name.orEmpty(),
        exerciseImg = this?.pathImg.orEmpty()
    )
}

internal fun InfantExerciseSearchResult?.toEntity(): InfantsExerciseEntity {
    return InfantsExerciseEntity(
        createdAt=this?.createdAt.orEmpty(),
        detailsEn=this?.detailsEn.orEmpty(),
        id=this?.id.orZero(),
        pathVideo=this?.pathVideo.orEmpty(),
        updatedAt=this?.updatedAt.orEmpty(),
        name = this?.name.orEmpty(),
        exerciseImg = this?.pathImg.orEmpty()
    )
}

internal fun ExerciseById?.toEntity(): InfantsExerciseEntity {
    return InfantsExerciseEntity(
        createdAt=this?.createdAt.orEmpty(),
        detailsEn=this?.detailsEn.orEmpty(),
        id=this?.id.orZero(),
        pathVideo=this?.pathVideo.orEmpty(),
        updatedAt=this?.updatedAt.orEmpty(),
        name = this?.name.orEmpty(),
        exerciseImg = this?.pathImg.orEmpty()
    )
}