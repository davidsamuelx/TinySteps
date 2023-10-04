package com.aa.usecase

import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class DeleteBabyGenderUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (babyId: String){
        return pregnancyRepository.deleteBabyGender(babyId)
    }
}