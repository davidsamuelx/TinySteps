package com.aa.usecase.kids

import com.aa.models.kids.AnimalGameEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class AnimalGameUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke(id: Int?): Any = if (id != null) {
        kidsRepository.getAnimalGameById(id)
    } else {
        getAnimalGame()
    }

    private suspend fun getAnimalGame(): List<AnimalGameEntity> {
        return kidsRepository.getAnimalGame()
    }
}
