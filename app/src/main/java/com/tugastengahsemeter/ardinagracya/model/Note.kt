
package com.tugastengahsemeter.ardinagracya.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Note(val id: Int = (0..100).random(), val nama: String, val deskripsi: String) : Parcelable