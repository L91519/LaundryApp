package com.example.laundryapp.data.firebase.source

import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.text.SimpleDateFormat
import java.util.*

class FirebaseSourceImpl constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseFirestore
) :
    FirebaseSource {
//    private val firebaseAuth: FirebaseAuth by lazy {
//        FirebaseAuth.getInstance()
//    }
//    private val firebaseDatabase: FirebaseFirestore by lazy {
//        FirebaseFirestore.getInstance()
//    }

    private val laundries: CollectionReference =
        firebaseDatabase.collection("laundries")

    private val cal: Date = Calendar.getInstance().time
    private val dateFormat = SimpleDateFormat("yyyyMMdd")

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

    override fun logout(
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) = firebaseAuth.signOut()

    override fun sendPwReset(
        email: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                success()
            }
            .addOnFailureListener { e ->
                fail(e)
            }
    }

    override fun currentUser() = firebaseAuth.currentUser

    override fun addLaundry(
        laundry: LaundryModel,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {

        currentUser()?.uid?.let {
            firebaseDatabase.collection("users")
                .document(it)
                .collection("laundries")
                .document(laundry.id.toString())
                .set(laundry)
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
//        Log.d("tag_dateFormat", dateFormat.format(cal).toString())
//        Log.d("tag_dateFormat-100", (dateFormat.format(cal).toInt()-100).toString())
        currentUser()?.uid?.let { user ->
            firebaseDatabase.collection("users")
                .document(user)
                .collection("laundries")
                .whereGreaterThan("date", dateFormat.format(cal).toInt() - 100)
                .get()
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
        }
    }

    override fun updateIsDoneStatus(
        isDone: Boolean,
        laundryId: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        currentUser()?.uid?.let { user ->
            firebaseDatabase.collection("users")
                .document(user)
                .collection("laundries")
                .document(laundryId)
                .update("done", isDone)
                .addOnSuccessListener {
                    success()
                }
                .addOnFailureListener { e ->
                    fail(e)
                }
        }
    }

    override fun getPagingQuery(
        success: (Query) -> Unit,
        fail: (Exception) -> Unit
    ) {
        try {
            currentUser()?.uid?.let { user ->
                val postsCollection =
                    firebaseDatabase.collection("users").document(user).collection("laundries")
                val query = postsCollection.orderBy("date", Query.Direction.DESCENDING)
                success(query)
            }
        } catch (e: Exception) {
            fail(e)
        }

    }
}