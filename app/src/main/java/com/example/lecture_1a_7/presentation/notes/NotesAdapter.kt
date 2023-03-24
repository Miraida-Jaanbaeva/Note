package com.example.lecture_1a_7.presentation.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lecture_1a_7.databinding.ItemNotesBinding
import com.example.lecture_1a_7.domain.model.Note

class NotesAdapter(
    private val onItemClickListener: (Note) -> Unit,
    private val onLongItemClickListener: (Note) -> Unit
) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private var list = mutableListOf<Note>()
    private var deletedNote: Note? = null

    fun updateList(notes: List<Note>) {
        list = notes as MutableList<Note>
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note) {
            with(binding) {
                itemNotesTitle.text = note.title
                itemNotesDesc.text = note.description

                root.setOnClickListener {
                    onItemClickListener(note)
                }
                root.setOnLongClickListener {
                    deletedNote = note
                    onLongItemClickListener(note)

                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun deleted() {
        if (deletedNote != null) {
            list.remove(deletedNote)
            deletedNote = null
            notifyDataSetChanged()
        }
    }
}