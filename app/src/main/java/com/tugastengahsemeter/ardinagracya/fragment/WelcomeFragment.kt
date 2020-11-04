
package com.tugastengahsemeter.ardinagracya.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.tugastengahsemeter.ardinagracya.R
import kotlinx.android.synthetic.main.fragment_welcome.*
import com.tugastengahsemeter.ardinagracya.utils.CustomNavigation
import com.tugastengahsemeter.ardinagracya.viewModel.WelcomeViewModel


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Halaman Depan"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val welcomeViewModel = WelcomeViewModel.INSTANCE



        welcomeViewModel.setUsers(nama = "Ardina Surya Gracya", nim = 185410118, email = "ardinasurya2299@gmial.com").apply {

            textview_nama.text = this.nama
            textview_nim.text = this.nim.toString()
            textview_email.text = this.email
        }

        imageview_profile.setImageResource(R.drawable.ardina)

        buttonLanjut.setOnClickListener(CustomNavigation.instance.createNavigation(R.id.action_welcomeFragment_to_noteFragment))
    }
}