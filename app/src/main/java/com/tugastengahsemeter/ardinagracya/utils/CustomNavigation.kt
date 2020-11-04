package com.tugastengahsemeter.ardinagracya.utils


import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation


class CustomNavigation {


    companion object {
        val instance = CustomNavigation()
    }

    fun createNavigation(resId: Int) : View.OnClickListener {
       return Navigation.createNavigateOnClickListener(resId)
    }


    fun navigateTo(view: View, resId: Int, args: Bundle?) {
        Navigation.findNavController(view).navigate(resId, args)
    }


    fun popBack(view: View) {
        Navigation.findNavController(view).popBackStack()
    }
}