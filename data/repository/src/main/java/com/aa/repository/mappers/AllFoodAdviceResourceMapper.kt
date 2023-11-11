package com.aa.repository.mappers

import com.aa.models.AllFoodAdviceEntity
import com.aa.repository.resources.FoodBaby
import com.aa.repository.resources.FoodBabyResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun FoodBaby.toEntity2(): AllFoodAdviceEntity {
    return AllFoodAdviceEntity(
        adviceId = iD.orZero(),
        detailsOfFood = detailsOfFood.orEmpty(),
        doctorName = advices?.doctorName.orEmpty(),
        imgFood = imgFood.orEmpty() ,
        nameFood = nameFood.orEmpty() ,
        nameProblem = advices?.nameProblem.orEmpty() ,
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty()
    )
}