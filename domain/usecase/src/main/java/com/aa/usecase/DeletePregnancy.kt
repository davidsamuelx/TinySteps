package com.aa.usecase

import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class DeletePregnancy @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke (id: Int){
        return pregnancyRepository.deletePregnancy(id)
    }
}