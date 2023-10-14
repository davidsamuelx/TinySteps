package com.aa.repository.mappers

import com.aa.models.kids.AchievementsEntity
import com.aa.repository.resources.kids.RecordResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun RecordResource?.toEntity():AchievementsEntity{
    return AchievementsEntity(
        gamesHowManyDifferenceOfImages = this?.gamesHowManyDifferenceOfImages.orEmpty(),
        gamesMathland = this?.gamesMathland.orEmpty(),
        id = this?.id.orZero(),
        isCorrect = this?.isCorrect.orEmpty(),
        levels = this?.levels.orEmpty(),
        titleOfGamePuzzleLevelOne = this?.titleOfGamePuzzleLevelOne.orEmpty(),
        titleOfGamePuzzleLevelTwo = this?.titleOfGamePuzzleLevelTwo.orEmpty(),
        titleOfGamePuzzleLevelThree = this?.titleOfGamePuzzleLevelThree.orEmpty()
    )
}