package com.aa.usecase

import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class UpdateBabyGenderUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (
        babyId: String,
        babyGender: String
    ) {
        return pregnancyRepository.updateBabyGender(
            babyId = babyId,
            babyGender = babyGender
        )
    }
}