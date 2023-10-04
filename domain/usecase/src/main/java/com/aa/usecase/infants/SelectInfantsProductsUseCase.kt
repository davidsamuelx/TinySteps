package com.aa.usecase.infants

import com.aa.models.infants.InfantsProductsEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SelectInfantsProductsUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
){
    suspend operator fun invoke(id:String): InfantsProductsEntity? {
        return infantsRepository.selectInfantsProducts(id)
    }
}