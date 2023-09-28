package com.aa.repository.mappers

import com.aa.models.AllFoodAdviceEntity
import com.aa.repository.resources.FoodBabyResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun FoodBabyResource.toEntity(): AllFoodAdviceEntity {
    return AllFoodAdviceEntity(
        adviceId = adviceId.orZero(),
        detailsOfFood = detailsOfFood.orEmpty(),
        doctorName = doctorName.orEmpty(),
        imgFood = imgFood.orEmpty() ,
        nameFood = nameFood.orEmpty() ,
        nameProblem = nameProblem.orEmpty() ,
        phoneDoctor = phoneDoctor.orEmpty(),
        solveProblem = solveProblem.orEmpty()
    )
}