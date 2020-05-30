package com.example.laundryapp.data.firebase.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseRepository {

    fun login(
        email: String, pw: String
        , success: (Boolean) -> Unit,
        fail: (Boolean) -> Unit
    )

    fun register(
        email: String, pw: String,
        success: (Boolean) -> Unit,
        fail: (Boolean) -> Unit
    )

    fun logout()

    fun currentUser(): FirebaseUser?
}