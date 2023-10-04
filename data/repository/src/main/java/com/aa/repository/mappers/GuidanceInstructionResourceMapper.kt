package com.aa.repository.mappers

import com.aa.models.GuidanceInstructionEntity
import com.aa.repository.resources.Infants.GuidanceInstructionResource

internal fun GuidanceInstructionResource.toEntity():GuidanceInstructionEntity{
    return GuidanceInstructionEntity(
        titleEN=titleEN.orEmpty(),
        detailsEn=detailsEn.orEmpty(),
        doctorName=advices?.doctorName.orEmpty(),
        doctorLocation=advices?.doctorLocation.orEmpty(),
        profileDoctor=advices?.profileDoctor.orEmpty(),
        phoneDoctor= advices?.phoneDoctor.orEmpty(),

    )
}