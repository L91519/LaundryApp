package com.example.laundryapp.data.firebase.source

import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseSourceImpl() :
    FirebaseSource {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val firebaseDatabase: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    private val laundries: CollectionReference by lazy {
        firebaseDatabase.collection("laundries")
    }

//    private val firebaseReference : DatabaseReference by lazy {
//        firebaseDatabase.reference
//    }

    override fun login(
        email: String,
        pw: String,
        success: (Boolean) -> Unit,
        fail: (Boolean) -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, pw).addOnCompleteListener {
            if (it.isSuccessful) {
                success(true)
            } else if (it.isCanceled) {
                fail(false)
            }
        }
    }

    override fun register(
        email: String,
        pw: String,
        success: (Boolean) -> Unit,
        fail: (Boolean) -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, pw).addOnCompleteListener {
            if (it.isSuccessful) {
                success(true)
            } else if (it.isCanceled) {
                fail(false)
            }
        }
    }

    override fun logout() = firebaseAuth.signOut()

    override fun currentUser() = firebaseAuth.currentUser

    override fun addLaundry(laundry: LaundryModel) {
        laundries.add(
            laundry
        ).addOnSuccessListener {

        }.addOnCanceledListener {

        }
    }

    override fun delLaundry(laundry: LaundryModel) {
        TODO("Not yet implemented")
    }

    override fun getLaundries(): MutableList<LaundryModel> {
        TODO("Not yet implemented")
    }
}