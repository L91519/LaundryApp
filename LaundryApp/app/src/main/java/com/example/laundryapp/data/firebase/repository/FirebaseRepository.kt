package com.example.laundryapp.data.firebase.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseRepository {

    fun login(email: String, pw: String)

    fun register(email: String, pw: String)

    fun logout()

    fun currentUser(): FirebaseUser?
}