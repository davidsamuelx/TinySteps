package com.aa.usecase.kids

import com.aa.models.kids.KidsSpecialCaseEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class SelectKidsSpecialCaseUseCase  @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (id:Int): KidsSpecialCaseEntity {
        return kidsRepository.selectKidsSpecialCase(id)
    }
}