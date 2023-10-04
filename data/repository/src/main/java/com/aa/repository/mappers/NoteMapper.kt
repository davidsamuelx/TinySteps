package com.aa.repository.mappers

import com.aa.models.AddNoteEntity
import com.aa.models.NoteEntity
import com.aa.repository.resources.NoteResource
import com.aa.repository.resources.NoteResponceResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun AddNoteEntity.toResource(): NoteResource{
    return NoteResource(
        tMedicine = medicineTime.orEmpty(),
        tDoctor = doctorTime.orEmpty(),
        note = note.orEmpty()
    )
}

internal fun NoteResponceResource.toEntity(): NoteEntity{
    return NoteEntity(
        id = newRecord?.id.orZero(),
        message = message.orEmpty(),
        medicineTime = newRecord?.tMedicine.orEmpty(),
        doctorTime = newRecord?.tDoctor.orEmpty(),
        note = newRecord?.note.orEmpty()

    )
}