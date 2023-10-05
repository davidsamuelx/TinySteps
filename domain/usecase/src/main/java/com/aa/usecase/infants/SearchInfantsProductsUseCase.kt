package com.aa.usecase.infants

import com.aa.models.infants.InfantsProductsEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchInfantsProductsUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(prducts:String):List<InfantsProductsEntity>{
        return infantsRepository.searchInfantsProducts(prducts).shuffled()
    }
}