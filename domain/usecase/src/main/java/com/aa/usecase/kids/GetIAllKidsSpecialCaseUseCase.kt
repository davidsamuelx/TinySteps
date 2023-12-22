package com.aa.usecase.kids

import com.aa.models.kids.KidsSpecialCaseEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class GetIAllKidsSpecialCaseUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (): List<KidsSpecialCaseEntity> {
        return kidsRepository.getAllKidsSpecialCase().shuffled()
    }
}