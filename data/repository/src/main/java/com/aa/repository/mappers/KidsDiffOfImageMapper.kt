package com.aa.repository.mappers

import com.aa.models.kids.DiffImageGameEntity
import com.aa.repository.resources.kids.DiffOfTwoImageResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun DiffOfTwoImageResource?.toEntity():DiffImageGameEntity{
    return DiffImageGameEntity(
        howManyDifference = this?.howManyDifference.orZero(),
        id = this?.id.orZero(),
        pathImgOne = this?.pathImgOne.orEmpty(),
        pathImgTwo = this?.pathImgTwo.orEmpty(),
        chooseOne=this?.chooseOne.orZero(),
        chooseTwo=this?.chooseTwo.orZero(),
        chooseThree=this?.chooseThree.orZero(),
        chooseFour=this?.chooseFour.orZero()
    )
}