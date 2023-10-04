package com.aa.usecase

import com.aa.models.AddNoteEntity
import com.aa.models.NoteEntity
import com.aa.repositories.PregnancyRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val pregnancyRepository: PregnancyRepository
) {
    suspend operator fun invoke(
        addNoteEntity: AddNoteEntity
    ): NoteEntity{
        return pregnancyRepository.addNote(addNoteEntity)
    }
}