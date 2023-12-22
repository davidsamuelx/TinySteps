package com.aa.usecase.kids

import com.aa.models.kids.KidsSpecialCaseEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class SearchKidsSpecialCaseUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (specialCase:String): List<KidsSpecialCaseEntity> {
        return kidsRepository.searchKidsSpecialCase(specialCase)
    }
}