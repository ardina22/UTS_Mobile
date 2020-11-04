
package com.tugastengahsemeter.ardinagracya.viewModel

import androidx.lifecycle.ViewModel
import com.tugastengahsemeter.ardinagracya.model.User


class WelcomeViewModel : ViewModel() {


    companion object {
        val INSTANCE: WelcomeViewModel = WelcomeViewModel()
    }

    fun setUsers(nama: String, nim: Int, email: String): User = User(nama, nim, email)

}