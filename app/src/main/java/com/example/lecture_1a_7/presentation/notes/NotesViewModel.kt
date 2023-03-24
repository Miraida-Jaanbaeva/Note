package com.example.lecture_1a_7.presentation.notes

import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.domain.usecase.DeleteNoteUseCase
import com.example.lecture_1a_7.domain.usecase.GetAllNotesUseCase
import com.example.lecture_1a_7.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    private val _notesState = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val noteState = _notesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_notesState)
    }

    fun delete(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }
}