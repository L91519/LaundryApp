package com.example.laundryapp.ui.auth

interface AuthListener {
    fun onStarted()

    fun onSuccess()

    fun onFailure(message: String)
}