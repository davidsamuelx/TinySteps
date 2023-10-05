package com.aa.usecase.infants

import com.aa.models.infants.InfantsProductsEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetInfantsProductsUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke():List<InfantsProductsEntity>{
        return infantsRepository.getInfantsProducts().shuffled()
    }
}