package com.aa.repository.mappers

import com.aa.models.kids.KidsFoodEntity
import com.aa.repository.resources.kids.FoodBaby
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun FoodBaby?.toEntity():KidsFoodEntity{
    return KidsFoodEntity(
        id = this?.iD.orZero(),
        detailsOfFood = this?.detailsOfFood.orEmpty(),
        imgFood = this?.imgFood.orEmpty(),
        nameFood = this?.nameFood.orEmpty(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        nameProblem = this?.advices?.nameProblem.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
        specificFood = this?.specificFood.orEmpty()
    )
}
