package com.aa.repository.mappers

import com.aa.models.infants.InfantsProductsEntity
import com.aa.repository.resources.Infants.InfantsProductsResource
import com.aa.repository.resources.Infants.Products
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun InfantsProductsResource?.toEntity(): InfantsProductsEntity {
    return InfantsProductsEntity(
        detailsEN = this?.detailsEN.orEmpty(),
        iD = this?.iD.orZero(),
        nameProductEN = this?.nameProductEN.orEmpty(),
        pathImg = this?.pathImg.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty()
    )
}
internal fun Products?.toEntity():InfantsProductsEntity{
    return InfantsProductsEntity(
        iD = this?.iD.orZero(),
        nameProductEN = this?.nameProductEN.orEmpty(),
        pathImg = this?.pathImg.orEmpty(),
        detailsEN = this?.detailsEN.orEmpty(),
        adviceId = this?.advices?.adviceId.orZero(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty()
    )
}