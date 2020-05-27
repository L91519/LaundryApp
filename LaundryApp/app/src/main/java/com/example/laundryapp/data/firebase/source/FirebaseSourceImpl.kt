package com.example.laundryapp.data.firebase.source

import com.example.laundryapp.data.firebase.source.FirebaseSource
import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseSourceImpl() :
    FirebaseSource {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val firebaseDatabase: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

//    private val firebaseReference : DatabaseReference by lazy {
//        firebaseDatabase.reference
//    }

    override fun login(email: String, pw: String) {
        firebaseAuth.signInWithEmailAndPassword(email, pw).addOnCompleteListener {
            if (it.isSuccessful) {

            } else if (it.isCanceled) {

            }
        }
    }

    override fun register(email: String, pw: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, pw).addOnCompleteListener {
            if (it.isSuccessful) {

            } else if (it.isCanceled) {

            }
        }
    }

    override fun logout() = firebaseAuth.signOut()

    override fun currentUser() = firebaseAuth.currentUser

    override fun addLaundry() {
        TODO("Not yet implemented")
    }

    override fun delLaundry() {
        TODO("Not yet implemented")
    }

    override fun getLaundries(): MutableList<LaundryModel> {
        TODO("Not yet implemented")
    }
}