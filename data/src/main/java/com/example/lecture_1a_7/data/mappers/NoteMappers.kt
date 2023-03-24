package com.example.lecture_1a_7.data.mappers

import com.example.lecture_1a_7.data.model.NoteEntity
import com.example.lecture_1a_7.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createdAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createdAt
)