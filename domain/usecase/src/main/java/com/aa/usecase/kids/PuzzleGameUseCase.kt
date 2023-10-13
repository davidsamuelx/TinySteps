package com.aa.usecase.kids

import com.aa.models.kids.PuzzleGameEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class PuzzleGameUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {
    suspend operator fun invoke (level:String):List<PuzzleGameEntity>{
        return kidsRepository.getPuzzleGame(level)
    }
}