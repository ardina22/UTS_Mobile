
package com.tugastengahsemeter.ardinagracya.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.tugastengahsemeter.ardinagracya.R
import kotlinx.android.synthetic.main.fragment_detail.*
import com.tugastengahsemeter.ardinagracya.utils.CustomNavigation
import com.tugastengahsemeter.ardinagracya.viewModel.NoteViewModel

class DetailFragment : Fragment() {
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Detail Note"
        noteViewModel = NoteViewModel.instance
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel.getNoteByBundle(arguments).apply {

            if (this != null) {
                textview_detailNamaNote.text = this.nama
                textview_detailDeskripsi.text = this.deskripsi
                textview_detailNoteId.text = this.id.toString()
            }
        }

        buttonKembali.setOnClickListener {
            CustomNavigation.instance.popBack(requireView())
            activity?.title = "Daftar Note"
        }
    }
}