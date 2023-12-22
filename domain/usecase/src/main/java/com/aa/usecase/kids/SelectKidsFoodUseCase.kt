package com.aa.usecase.kids

import com.aa.models.kids.KidsFoodEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class SelectKidsFoodUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (id:Int):KidsFoodEntity{
        return kidsRepository.selectKidsFood(id)
    }
}