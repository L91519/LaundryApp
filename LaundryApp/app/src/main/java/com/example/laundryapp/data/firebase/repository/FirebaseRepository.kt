package com.example.laundryapp.data.firebase.repository

import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.Query

interface FirebaseRepository {

    fun login(
        email: String, pw: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    )

    fun register(
        email: String, pw: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    )

    fun logout(
        success: () -> Unit,
        fail: (Exception) -> Unit
    )

    fun sendPwReset(email: String,
                    success: () -> Unit,
                    fail: (Exception) -> Unit)

    fun currentUser(): FirebaseUser?

    fun addItem(
        laundryModel: LaundryModel,
        success: () -> Unit,
        fail: (Exception) -> Unit
    )

    fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Exception) -> Unit
    )

    fun updateIsDoneStatus(
        isDone: Boolean,
        laundryId: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    )

    fun getPagingQuery(
        success: (Query) -> Unit,
        fail: (Exception) -> Unit
    )
}