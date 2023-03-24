package com.example.lecture_1a_7.domain.usecase

import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    operator fun invoke(note: Note) = repository.deleteNote(note)
}