package com.aa.usecase.infants

import com.aa.models.InfantsSleepEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SelectInfantsSleepUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(id:Int):InfantsSleepEntity{
        return infantsRepository.selectInfantsSleep(id)
    }
}