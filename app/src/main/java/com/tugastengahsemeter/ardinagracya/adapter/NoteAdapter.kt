
package com.tugastengahsemeter.ardinagracya.adapter

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.tugastengahsemeter.ardinagracya.R
import androidx.recyclerview.widget.RecyclerView
import com.tugastengahsemeter.ardinagracya.model.Note
import kotlinx.android.synthetic.main.list_note.view.*
import com.tugastengahsemeter.ardinagracya.utils.CustomNavigation

class NoteAdapter(private var noteLists: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    companion object {
        fun instance(noteLists: List<Note>) = NoteAdapter(noteLists)
    }

    fun listNote(listNote: List<Note>) {
        noteLists = listNote
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_note, parent, false))
    }

    override fun getItemCount(): Int = noteLists.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.getNote(noteLists[position])
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        fun getNote(note: Note) {
            with(itemView) {
                textview_namaNote.text = note.nama

                textview_detail.setOnClickListener {
                    val data = Bundle()
                    data.putParcelable("notes", note)
                    CustomNavigation.instance.navigateTo(it, R.id.action_noteFragment_to_detailFragment, data)
                }
            }
        }
    }
}