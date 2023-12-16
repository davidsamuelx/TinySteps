package com.aa.repository.mappers

import com.aa.models.kids.LetterEntity
import com.aa.repository.resources.kids.Letter
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun Letter?.toEntity(): LetterEntity {
    return LetterEntity(
        id = this?.id.orZero(),
        image = this?.image.orEmpty(),
        letter = this?.letter.orEmpty(),
        levels = this?.levels.orEmpty(),
        sound = this?.sound.orEmpty()
    )
}