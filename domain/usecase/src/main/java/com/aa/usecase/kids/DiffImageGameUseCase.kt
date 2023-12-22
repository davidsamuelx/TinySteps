package com.aa.usecase.kids

import com.aa.models.kids.DiffImageGameEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class DiffImageGameUseCase @Inject constructor(
    private val kidsRepository: KidsRepository,
) {

    suspend operator fun invoke(): List<DiffImageGameEntity> {
        return kidsRepository.getDiffImageGame().shuffled()
    }
}