package com.example.laundryapp.data.firebase.source

import android.util.Log
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

    private val laundries: CollectionReference =
        firebaseDatabase.collection("laundries")

//    private val firebaseReference : DatabaseReference by lazy {
//        firebaseDatabase.reference
//    }

    override fun login(
        email: String,
        pw: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, pw)
            .addOnSuccessListener {
                success()
            }.addOnFailureListener { e ->
                fail(e)
            }
    }

    override fun register(
        email: String,
        pw: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, pw)
            .addOnSuccessListener {
                success()
            }.addOnFailureListener { e ->
                fail(e)

        }
    }

    override fun logout() = firebaseAuth.signOut()

    override fun currentUser() = firebaseAuth.currentUser

    override fun addLaundry(
        laundry: LaundryModel,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {

//        laundries.document(laundry.id.toString()).set(laundry)

        currentUser()?.uid?.let {
            firebaseDatabase.collection("users")
                .document(it)
                .collection("laundries")
                .add(laundry)
                .addOnSuccessListener {
                    success()
                }.addOnFailureListener { e ->
                    fail(e)
                }
        }
    }

    override fun delLaundry(
        laundry: LaundryModel,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Exception) -> Unit
    ) {
        currentUser()?.uid?.let {
            firebaseDatabase.collection("users")
                .document(it)
                .collection("laundries").get()
                .addOnSuccessListener { documents ->
                    mutableListOf<LaundryModel>().let { laundryModels ->
                        for (document in documents) {
                            laundryModels.add(document.toObject(LaundryModel::class.java))
                        }
                        success(laundryModels)
                    }
                }
                .addOnFailureListener { e ->
                    fail(e)
                }
                .addOnCompleteListener {
                    Log.d("","")
                }
        }
    }
}