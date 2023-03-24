package com.example.lecture_1a_7.domain.repository

import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(note: Note): Flow<ResultStatus<Unit>>
    fun updateNote(note: Note): Flow<ResultStatus<Unit>>
    fun deleteNote(note: Note): Flow<ResultStatus<Unit>>
    fun getAllNotes(): Flow<ResultStatus<List<Note>>>
}