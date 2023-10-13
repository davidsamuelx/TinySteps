package com.aa.usecase.kids

import com.aa.models.kids.EducationGameEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class EducationUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke ():List<EducationGameEntity>{
        return kidsRepository.getEducationGame()
    }
}