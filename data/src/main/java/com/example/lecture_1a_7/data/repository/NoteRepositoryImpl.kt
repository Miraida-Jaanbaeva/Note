package com.example.lecture_1a_7.data.repository

import com.example.lecture_1a_7.data.base.BaseRepository
import com.example.lecture_1a_7.data.local.NoteDao
import com.example.lecture_1a_7.data.mappers.toNote
import com.example.lecture_1a_7.data.mappers.toNoteEntity
import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.domain.repository.NoteRepository
import com.example.lecture_1a_7.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        dao.insert(note.toNoteEntity())
    }

    override fun updateNote(note: Note) = doRequest {
        dao.update(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        dao.delete(note.toNoteEntity())
    }

    override fun getAllNotes() = doRequest {
        dao.getAllNotes().map { it.toNote() }
    }
}