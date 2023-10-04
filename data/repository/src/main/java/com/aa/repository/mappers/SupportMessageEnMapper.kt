package com.aa.repository.mappers

import com.aa.models.AllSupportMessagesEntity
import com.aa.models.SelectedSupportMessageEntity
import com.aa.models.SupportMessageEntity
import com.aa.repository.resources.ENRecordResource
import com.aa.repository.resources.SearchedENSupportMessageResource
import com.aa.repository.resources.SelectedSupportMessageTypeResource
import com.aa.repository.resources.SupportMessageEnglishResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun SelectedSupportMessageEntity.toResource(): SelectedSupportMessageTypeResource{
    return SelectedSupportMessageTypeResource(
        selectWhenSendSupportMessage = supportMessageType.orEmpty()
    )
}

internal fun SupportMessageEnglishResource.toEntity(): SupportMessageEntity{
    return SupportMessageEntity(
        message = message.orEmpty(),
        supportMessageType = selectTimes.orEmpty(),
        id = newRecord?.id.orZero()

    )
}

internal fun ENRecordResource.toEntity(): AllSupportMessagesEntity{
    return AllSupportMessagesEntity(
        id = id.orZero(),
        supportMessageType = selectWhenSendSupportMessage.orEmpty()
    )
}

internal fun SearchedENSupportMessageResource.toEntity(): SupportMessageEntity{
    return SupportMessageEntity(
        id = searchedENRecord?.id.orZero(),
        message = message.orEmpty(),
        supportMessageType = searchedENRecord?.selectWhenSendSupportMessage.orEmpty()
    )
}