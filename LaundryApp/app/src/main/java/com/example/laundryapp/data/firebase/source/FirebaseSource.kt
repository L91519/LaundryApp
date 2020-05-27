package com.example.laundryapp.data.firebase.source

import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseUser

interface FirebaseSource {
    fun login(email: String, pw: String)

    fun register(email: String, pw: String)

    fun logout()

    fun currentUser(): FirebaseUser?

    fun addLaundry()

    fun delLaundry()

    fun getLaundries() : MutableList<LaundryModel>

}