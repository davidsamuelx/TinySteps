package com.aa.repository.mappers

import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.repository.resources.Infants.GuidanceDetailsInstruction
import com.aa.repository.resources.Infants.GuidanceInstruction
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun GuidanceInstruction?.toEntity(): GuidanceInstructionEntity {
    return GuidanceInstructionEntity(
        id = this?.id.orZero(),
        titleEN = this?.titleEN.orEmpty(),
        detailsEn = this?.detailsEn.orEmpty(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        image = this?.pathImg.orEmpty()
        )
}

internal fun GuidanceDetailsInstruction?.toEntity(): GuidanceInstructionEntity{
    return GuidanceInstructionEntity(
        id = this?.id.orZero(),
        titleEN = this?.titleEN.orEmpty(),
        detailsEn = this?.detailsEn.orEmpty(),
        doctorName = this?.advices?.doctorName.orEmpty(),
        doctorLocation = this?.advices?.doctorLocation.orEmpty(),
        profileDoctor = this?.advices?.profileDoctor.orEmpty(),
        phoneDoctor = this?.advices?.phoneDoctor.orEmpty(),
        image = this?.pathImg.orEmpty()
    )
}



