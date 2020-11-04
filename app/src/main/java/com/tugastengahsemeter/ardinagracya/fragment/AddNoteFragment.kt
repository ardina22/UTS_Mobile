
package com.tugastengahsemeter.ardinagracya.fragment

import android.os.Bundle
import android.view.View
import android.app.Dialog
import android.widget.Toast
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.tugastengahsemeter.ardinagracya.R
import com.tugastengahsemeter.ardinagracya.model.Note
import kotlinx.android.synthetic.main.fragment_add_note.*
import com.tugastengahsemeter.ardinagracya.utils.AddNoteDialog
import com.tugastengahsemeter.ardinagracya.viewModel.NoteViewModel

class AddNoteFragment : DialogFragment() {

    companion object {
        val instance = AddNoteFragment()
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = NoteViewModel.instance

        buttonSimpan.setOnClickListener {
            viewModel.addNote(
                Note(
                    nama = edittext_nama.text.toString(),
                    deskripsi = edittext_deksripsi.text.toString()
                )
            )

            AddNoteDialog.instance.showText(requireContext(), "Note Berhasil Ditambahkan", Toast.LENGTH_SHORT)
            dismiss()
        }
    }

}