
package com.tugastengahsemeter.ardinagracya.viewModel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.tugastengahsemeter.ardinagracya.model.Note

class NoteViewModel : ViewModel() {


    companion object {
        val instance = NoteViewModel()
    }


    val listNote: MutableList<Note> = mutableListOf()


    fun addNote(note: Note) = listNote.add(note)


    fun getAllNote() : MutableLiveData<List<Note>> {
        val mutableLiveData = MutableLiveData<List<Note>>()
        mutableLiveData.value = listNote
        return mutableLiveData
    }


    fun getNoteByBundle(args: Bundle?) : Note? {
        return args?.getParcelable("notes")
    }
}