
package com.tugastengahsemeter.ardinagracya.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import com.tugastengahsemeter.ardinagracya.R
import kotlinx.android.synthetic.main.fragment_note.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.tugastengahsemeter.ardinagracya.adapter.NoteAdapter
import com.tugastengahsemeter.ardinagracya.utils.AddNoteDialog
import com.tugastengahsemeter.ardinagracya.viewModel.NoteViewModel

class NoteFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Daftar Note"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val noteViewModel = NoteViewModel.instance
        val adapter = NoteAdapter.instance(ArrayList())

        noteViewModel.getAllNote().observe(viewLifecycleOwner, Observer {
            adapter.listNote(it)
        })

        rv_note.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_note.adapter = adapter

        floatingActionButton.setOnClickListener {
            AddNoteDialog.instance.showDialog(requireActivity(), AddNoteFragment.instance)
        }
    }
}