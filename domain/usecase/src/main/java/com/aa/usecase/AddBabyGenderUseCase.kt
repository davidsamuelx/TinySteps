package com.aa.usecase

import com.aa.models.BabyGenderEntity
import com.aa.models.StoreBabyGenderEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class AddBabyGenderUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(
        storeBabyGenderEntity: StoreBabyGenderEntity
    ): BabyGenderEntity {
        return pregnancyRepository.storeBabyGender(storeBabyGenderEntity)
    }
}