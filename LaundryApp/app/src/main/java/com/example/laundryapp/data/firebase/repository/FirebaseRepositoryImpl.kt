package com.example.laundryapp.data.firebase.repository

import com.example.laundryapp.data.firebase.source.FirebaseSource

class FirebaseRepositoryImpl constructor(private val firebase: FirebaseSource) :
    FirebaseRepository {

    override fun login(email: String, pw: String) = firebase.login(email, pw)

    override fun register(email: String, pw: String) = firebase.register(email, pw)

    override fun logout() = firebase.logout()

    override fun currentUser() = firebase.currentUser()

}