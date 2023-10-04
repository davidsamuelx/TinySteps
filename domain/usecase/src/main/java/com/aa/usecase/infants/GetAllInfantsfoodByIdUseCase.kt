package com.aa.usecase.infants

import com.aa.models.InfantsFoodEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsfoodByIdUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
){
    suspend operator fun invoke(id:Int):InfantsFoodEntity{
        return infantsRepository.infantsFoodById(id)
    }
}