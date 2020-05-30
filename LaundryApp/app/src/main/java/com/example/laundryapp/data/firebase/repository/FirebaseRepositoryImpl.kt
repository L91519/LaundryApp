package com.example.laundryapp.data.firebase.repository

import com.example.laundryapp.data.firebase.source.FirebaseSource

class FirebaseRepositoryImpl constructor(private val firebase: FirebaseSource) :
    FirebaseRepository {

    override fun login(
        email: String,
        pw: String,
        success: (Boolean) -> Unit,
        fail: (Boolean) -> Unit
    ) {
        firebase.login(email, pw, success, fail)
    }

    override fun register(
        email: String,
        pw: String,
        success: (Boolean) -> Unit,
        fail: (Boolean) -> Unit
    ) {
        firebase.register(email, pw, success, fail)
    }

    override fun logout() = firebase.logout()

    override fun currentUser() = firebase.currentUser()

}