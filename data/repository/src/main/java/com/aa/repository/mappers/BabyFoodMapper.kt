package com.aa.repository.mappers

import com.aa.models.SearchFoodEntity
import com.aa.repository.resources.FoodBaby
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun FoodBaby?.toEntity(): SearchFoodEntity{
    return SearchFoodEntity(
        detailsOfFood= this?.detailsOfFood.orEmpty(),
        id = this?.iD.orZero(),
        imgFood= this?.imgFood.orEmpty(),
        nameFood= this?.nameFood.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        nameProblem = this?.advices?.nameProblem.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty()
    )
}