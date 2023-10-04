package com.aa.usecase.infants

import com.aa.models.InfantsSleepEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class searchForInfantsSleepUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository

) {
    suspend operator fun invoke (id:String): List<InfantsSleepEntity> {
        return infantsRepository.searchInfantsSleep(id)
    }
}
