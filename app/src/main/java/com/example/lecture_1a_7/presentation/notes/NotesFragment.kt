package com.example.lecture_1a_7.presentation.notes

import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lecture_1a_7.R
import com.example.lecture_1a_7.databinding.FragmentNotesBinding
import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.presentation.base.BaseFragment
import com.example.lecture_1a_7.presentation.extension.showToast
import com.example.lecture_1a_7.presentation.extension.toJson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment :
    BaseFragment<NotesViewModel, FragmentNotesBinding>(FragmentNotesBinding::inflate) {

    override val vm: NotesViewModel by viewModels()
    private val adapter by lazy { NotesAdapter(this::onItemClick, this::onLongItemClick) }

    private fun onItemClick(note: Note) {
        val bundle = bundleOf().apply {
            putString(ARG_ADD_EDIT, note.toJson())
        }
        findNavController().navigate(R.id.action_notesFragment_to_addFragment, bundle)
    }

    private fun onLongItemClick(note: Note) {
        vm.delete(note)
    }

    override fun initialize() {
        binding.notesRv.adapter = adapter
    }

    override fun listeners() {
        binding.notesAddFab.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addFragment)
        }
    }

    override fun setupRequests() {
        vm.getAllNotes()

        vm.noteState.collectState(onLoading = {
            binding.notesProgress.isVisible = true
        }, onError = {
            binding.notesProgress.isVisible = false
            showToast(it)
        }, onSuccess = {
            binding.notesProgress.isVisible = false
            adapter.updateList(it)
        })

        vm.deleteNoteState.collectState(
            onLoading = {
                binding.notesProgress.isVisible = true
            },
            onError = {
                binding.notesProgress.isVisible = false
                showToast(it)
            },
            onSuccess = {
                binding.notesProgress.isVisible = false
                showToast(R.string.deleted)
                adapter.deleted()
            })

    }

    companion object {
        const val ARG_ADD_EDIT = "edit_note"
    }
}