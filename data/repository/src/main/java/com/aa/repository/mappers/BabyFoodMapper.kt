package com.aa.repository.mappers

import com.aa.models.SearchFoodEntity
import com.aa.repository.resources.FoodBaby
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun FoodBaby.toEntity(): SearchFoodEntity{
    return SearchFoodEntity(
        detailsOfFood=detailsOfFood.orEmpty(),
        id = iD.orZero(),
        imgFood=imgFood.orEmpty(),
        nameFood=nameFood.orEmpty(),
        adviceId = advices?.adviceId.orZero(),
        doctorName = advices?.doctorName.orEmpty(),
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        profileDoctor = advices?.profileDoctor.orEmpty(),
        nameProblem = advices?.nameProblem.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty()
    )
}