package com.aa.repository.mappers

import com.aa.models.AllFoodAdviceEntity
import com.aa.repository.resources.FoodBaby
import com.aa.repository.resources.FoodBabyById
import com.aa.repository.resources.FoodBabySearch
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
        solveProblem = advices?.solveProblem.orEmpty(),
        doctorLocation = advices?.doctorLocation.orEmpty()
    )
}

internal fun FoodBabyById?.toEntity(): AllFoodAdviceEntity{
    return AllFoodAdviceEntity(
        adviceId = this?.iD.orZero(),
        detailsOfFood = this?.detailsOfFood.orEmpty(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        imgFood = this?.imgFood.orEmpty() ,
        nameFood = this?.nameFood.orEmpty() ,
        nameProblem = this?.advices?.nameProblem.orEmpty() ,
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
    )
}

internal fun FoodBabySearch.toEntity(): AllFoodAdviceEntity{
    return AllFoodAdviceEntity(
        adviceId = iD.orZero(),
        detailsOfFood = detailsOfFood.orEmpty(),
        doctorName = advices?.doctorName.orEmpty(),
        imgFood = imgFood.orEmpty() ,
        nameFood = nameFood.orEmpty() ,
        nameProblem = advices?.nameProblem.orEmpty() ,
        phoneDoctor = advices?.phoneDoctor.orEmpty(),
        solveProblem = advices?.solveProblem.orEmpty(),
        doctorLocation = advices?.doctorLocation.orEmpty()
    )
}


