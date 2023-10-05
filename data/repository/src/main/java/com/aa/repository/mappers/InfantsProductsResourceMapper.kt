package com.aa.repository.mappers

import com.aa.models.infants.InfantsProductsEntity
import com.aa.repository.resources.Infants.InfantsProductsResource
import com.aa.repository.utils.orZero

internal fun InfantsProductsResource?.toEntity(): InfantsProductsEntity {
    return InfantsProductsEntity(
        this?.detailsEN.orEmpty(),
        this?.iD.orZero(),
        this?.nameProductEN.orEmpty(),
        this?.pathImg.orEmpty(),
        this?.advices?.adviceId.orZero(),
        this?.advices?.doctorName.orEmpty(),
        this?.advices?.phoneDoctor.orEmpty()
    )
}