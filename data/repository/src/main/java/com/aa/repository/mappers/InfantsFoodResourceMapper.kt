package com.aa.repository.mappers

import com.aa.models.infants.InfantsFoodEntity
import com.aa.repository.resources.Infants.AllInfantsFoodByIdResource
import com.aa.repository.resources.Infants.InfantsFoodResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun InfantsFoodResource?.toEntity(): InfantsFoodEntity {
    return InfantsFoodEntity(
        detailsOfFood=this?.detailsOfFood.orEmpty(),
        imgFood=this?.imgFood.orEmpty(),
        nameFood=this?.nameFood.orEmpty(),
        adviceId = this?.iD.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.advices?.solveProblem.orEmpty(),
        nameProblem =this?.advices?.nameProblem.orEmpty() ,
        doctorLocation = this?.advices?.doctorLocation.orEmpty()
        )
}
internal fun AllInfantsFoodByIdResource?.toEntity():InfantsFoodEntity{
    return InfantsFoodEntity(
        detailsOfFood=this?.foodBaby?.detailsOfFood.orEmpty(),
        imgFood=this?.foodBaby?.imgFood.orEmpty(),
        nameFood=this?.foodBaby?.nameFood.orEmpty(),
        adviceId = this?.foodBaby?.iD.orZero(),
        doctorName = this?.foodBaby?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.foodBaby?.advices?.phoneDoctor.orEmpty(),
        profileDoctor = this?.foodBaby?.advices?.profileDoctor.orEmpty(),
        solveProblem = this?.foodBaby?.advices?.solveProblem.orEmpty(),
        nameProblem =this?.foodBaby?.advices?.nameProblem.orEmpty() ,
        doctorLocation = this?.foodBaby?.advices?.doctorLocation.orEmpty()

    )
}
