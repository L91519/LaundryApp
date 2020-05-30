package com.example.laundryapp.data.firebase.source

import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseUser

interface FirebaseSource {
    fun login(email: String,
              pw: String,
              success: (Boolean) -> Unit,
              fail: (Boolean) -> Unit)

    fun register(email: String,
                 pw: String,
                 success: (Boolean) -> Unit,
                 fail: (Boolean) -> Unit)

    fun logout()

    fun currentUser(): FirebaseUser?

    fun addLaundry(laundry: LaundryModel)

    fun delLaundry(laundry: LaundryModel)

    fun getLaundries() : MutableList<LaundryModel>

}