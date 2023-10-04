package com.aa.usecase.infants

import com.aa.models.InfantsExcersiceEntity
import com.aa.repositories.InfantsRepository
import javax.inject.Inject

class SearchForInfantsExcersiceUseCase @Inject constructor(
    private val infantsRepository: InfantsRepository
) {
    suspend operator fun invoke(videoPath:String):List<InfantsExcersiceEntity>{
        return infantsRepository.searchInfantsExcersice(videoPath)
    }
}