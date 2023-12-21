package com.aa.usecase.kids

import com.aa.models.kids.KidsFoodEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class SearchKidsFoodUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (food:String): List<KidsFoodEntity> {
        return kidsRepository.searchKidsFood(food)
    }
}
