package com.aa.usecase

import com.aa.models.PregnancyResponseEntity
import com.aa.models.PregnancyStoreEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class AddPregnancyUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (
        pregnancyStoreEntity: PregnancyStoreEntity
    ) : PregnancyResponseEntity{
        return pregnancyRepository.addPregnancy(pregnancyStoreEntity)
    }
}