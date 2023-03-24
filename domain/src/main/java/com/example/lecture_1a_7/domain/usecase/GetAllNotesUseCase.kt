package com.example.lecture_1a_7.domain.usecase

import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.domain.repository.NoteRepository
import com.example.lecture_1a_7.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase  @Inject constructor(private val repository: NoteRepository) {
    operator fun invoke(): Flow<ResultStatus<List<Note>>> = repository.getAllNotes()
}