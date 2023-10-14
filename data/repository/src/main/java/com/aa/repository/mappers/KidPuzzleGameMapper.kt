package com.aa.repository.mappers

import com.aa.models.kids.PuzzleGameEntity
import com.aa.repository.resources.kids.PuzzleGameResourceItem
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun PuzzleGameResourceItem.toEntity():PuzzleGameEntity{
    return PuzzleGameEntity(
        details = details.orEmpty(),
        id = id.orZero(),
        level = level.orEmpty(),
        orderAnswer1 = orderAnswer1.orEmpty(),
        orderAnswer2 = orderAnswer2.orEmpty(),
        orderAnswer3 = orderAnswer3.orEmpty(),
        orderAnswer4 = orderAnswer4.orEmpty(),
        orderAnswer5 = orderAnswer5.orEmpty(),
        orderAnswer6 = orderAnswer6.orEmpty(),
        pathImg1 = pathImg1.orEmpty(),
        pathImg2 = pathImg2.orEmpty(),
        pathImg3 = pathImg3.orEmpty(),
        pathImg4 = pathImg4.orEmpty(),
        pathImg5 = pathImg5.orEmpty(),
        pathImg6 = pathImg6.orEmpty(),
        title = title.orEmpty()
    )
}