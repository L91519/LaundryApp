package com.example.laundryapp.data.model

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class UserModel(
    val uid: String,
    val name: String,
    val email: String
): Serializable