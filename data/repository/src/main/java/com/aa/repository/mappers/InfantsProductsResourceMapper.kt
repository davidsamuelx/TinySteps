package com.aa.repository.mappers

import com.aa.models.InfantsFoodEntity
import com.aa.models.InfantsProductsEntity
import com.aa.repository.resources.Infants.InfantsProductsResource
import com.aa.repository.utils.orZero

internal fun InfantsProductsResource.toEntity():InfantsProductsEntity{
    return InfantsProductsEntity(
        detailsEN.orEmpty(),
        iD.orZero(),
        nameProductEN.orEmpty(),
        pathImg.orEmpty(),
        advices?.adviceId.orZero(),
        advices?.doctorName.orEmpty(),
        advices?.phoneDoctor.orEmpty()
    )
}