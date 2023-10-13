package com.aa.repository.mappers

import com.aa.models.kids.AnimalGameEntity
import com.aa.repository.resources.kids.GameData
import com.aa.repository.resources.kids.GameDataResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun GameDataResource?.toEntity():AnimalGameEntity{
    return AnimalGameEntity(
        id = this?.id.orZero(),
        image = this?.image.orEmpty(),
        sound = this?.sound.orEmpty()
    )
}


internal fun GameData?.toEntity():AnimalGameEntity{
    return AnimalGameEntity(
        id = this?.id.orZero(),
        image = this?.image.orEmpty(),
        sound = this?.sound.orEmpty()
    )
}