package com.example.laundryapp.data.firebase.repository

import com.example.laundryapp.data.firebase.source.FirebaseSource
import com.example.laundryapp.data.model.LaundryModel
import com.google.firebase.firestore.Query

class FirebaseRepositoryImpl constructor(private val firebase: FirebaseSource) :
    FirebaseRepository {

    override fun login(
        email: String,
        pw: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.login(email, pw, success, fail)
    }

    override fun register(
        email: String,
        pw: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.register(email, pw, success, fail)
    }

    override fun logout(
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.logout(success, fail)
    }

    override fun sendPwReset(
        email: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.sendPwReset(email, success, fail)
    }

    override fun currentUser() = firebase.currentUser()

    override fun addItem(
        laundryModel: LaundryModel,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.addLaundry(laundryModel, success, fail)
    }

    override fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.getLaundries(success, fail)
    }

    override fun updateIsDoneStatus(
        isDone: Boolean,
        laundryId: String,
        success: () -> Unit,
        fail: (Exception) -> Unit
    ) {
        firebase.updateIsDoneStatus(isDone, laundryId, success, fail)
    }

    override fun getPagingQuery(
        success: (Query) -> Unit,
        fail: (Exception) -> Unit) {
        firebase.getPagingQuery(success, fail)
    }

}