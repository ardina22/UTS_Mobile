
package com.tugastengahsemeter.ardinagracya.utils

import android.widget.Toast
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.tugastengahsemeter.ardinagracya.model.Note
import com.tugastengahsemeter.ardinagracya.fragment.AddNoteFragment


class AddNoteDialog {


    companion object {
        val instance = AddNoteDialog()
    }

    fun showDialog(activity: FragmentActivity, dialogFragment: AddNoteFragment) {
        dialogFragment.show(activity.supportFragmentManager, "AddNoteDialog")
    }


    fun showText(context: Context, message: String, duration: Int) {
        Toast.makeText(context, message, duration).show()
    }
}