package com.aa.usecase.kids

import com.aa.models.kids.LetterEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class GetLetterUseCase @Inject constructor(
    private val kidsRepository: KidsRepository,
) {
    suspend operator fun invoke(id: Int): LetterEntity {
        return kidsRepository.getLetterById(id)
    }
}