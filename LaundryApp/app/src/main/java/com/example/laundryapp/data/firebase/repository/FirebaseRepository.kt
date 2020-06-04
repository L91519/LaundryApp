package com.example.laundryapp.data.firebase.repository

import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

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

    fun logout()

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
}