package com.example.laundryapp.data.model

import java.io.Serializable

data class UserModel(
    val uid: String,
    val name: String,
    val email: String
): Serializable