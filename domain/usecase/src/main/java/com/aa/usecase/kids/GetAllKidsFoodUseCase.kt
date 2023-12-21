package com.aa.usecase.kids

import com.aa.models.kids.KidsFoodEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class GetAllKidsFoodUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke ():List<KidsFoodEntity>{
        return kidsRepository.getAllKidsFood().shuffled()
    }
}