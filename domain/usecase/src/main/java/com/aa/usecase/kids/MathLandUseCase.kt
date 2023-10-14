package com.aa.usecase.kids

import com.aa.models.kids.MathLandEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class MathLandUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke(level: String): List<MathLandEntity>
    {
        return kidsRepository.getMathLand(level)
    }
}