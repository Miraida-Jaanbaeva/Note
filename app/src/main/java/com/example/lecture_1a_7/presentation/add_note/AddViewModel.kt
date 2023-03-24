package com.example.lecture_1a_7.presentation.add_note

import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.domain.usecase.CreateNoteUseCase
import com.example.lecture_1a_7.domain.usecase.UpdateNoteUseCase
import com.example.lecture_1a_7.presentation.base.BaseViewModel
import com.example.lecture_1a_7.presentation.notes.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : BaseViewModel() {

    private val _createState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createState = _createState.asStateFlow()

    private val _updateState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val updateState = _updateState.asStateFlow()

    fun create(title: String, desc: String) {
        if (title.isNotEmpty() && title.isNotBlank()) {
            createNoteUseCase(
                Note(
                    title = title,
                    description = desc,
                    createdAt = System.currentTimeMillis()
                )
            ).collectFlow(_createState)

        } else {
            _createState.value = UiState.Error("Title is empty!")
        }
    }

    fun update(note: Note) {
        if (note.title.isNotEmpty() && note.title.isNotBlank()) {
            updateNoteUseCase(
                note
            ).collectFlow(_updateState)

        } else {
            _updateState.value = UiState.Error("Title is empty!")
        }
    }

}