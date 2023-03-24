package com.example.lecture_1a_7.presentation.add_note

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lecture_1a_7.R
import com.example.lecture_1a_7.databinding.FragmentAddBinding
import com.example.lecture_1a_7.domain.model.Note
import com.example.lecture_1a_7.presentation.base.BaseFragment
import com.example.lecture_1a_7.presentation.extension.fromJson
import com.example.lecture_1a_7.presentation.extension.showToast
import com.example.lecture_1a_7.presentation.notes.NotesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : BaseFragment<AddViewModel, FragmentAddBinding>(FragmentAddBinding::inflate) {

    override val vm: AddViewModel by viewModels()
    private var note: Note? = null

    override fun initialize() {
        if (arguments != null) {
            note = requireArguments().getString(NotesFragment.ARG_ADD_EDIT)?.fromJson() as Note
            setData()
        }
    }

    private fun setData() {
        with(binding) {
            addTitleEdt.setText(note!!.title)
            addDescEdt.setText(note!!.description)
        }
    }

    override fun listeners() {
        with(binding) {
            addSaveBtn.setOnClickListener {
                if (note != null)
                    vm.update(
                        note!!.copy(
                            title = addTitleEdt.text.toString(),
                            description = addDescEdt.text.toString()
                        )
                    )
                else vm.create(
                    addTitleEdt.text.toString(),
                    addDescEdt.text.toString()
                )
            }
        }
    }

    override fun setupRequests() {
        vm.createState.collectState(
            onLoading = {

            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                showToast(R.string.created)
                findNavController().navigateUp()
            }
        )

        vm.updateState.collectState(
            onLoading = {

            },
            onError = {
                showToast(it)
            },
            onSuccess = {
                showToast(R.string.edited)
                findNavController().navigateUp()
            }
        )
    }
}