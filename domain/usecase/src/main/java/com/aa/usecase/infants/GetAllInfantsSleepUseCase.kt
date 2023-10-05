package com.aa.usecase.infants

import com.aa.models.infants.InfantsSleepEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class GetAllInfantsSleepUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository

) {
    suspend operator fun invoke (): List<InfantsSleepEntity> {
        return infantsRepository.infantsSleep().shuffled()
}
}