package com.aa.repository.mappers

import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.repository.resources.Infants.GuidanceInstructionResource

internal fun GuidanceInstructionResource?.toEntity(): GuidanceInstructionEntity {
    return GuidanceInstructionEntity(
        titleEN = this?.titleEN.orEmpty(),
        detailsEn = this?.detailsEn.orEmpty(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),

        )
}



