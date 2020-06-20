package com.example.laundryapp.ui.auth

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository

class AuthViewModel constructor(private val repository: FirebaseRepository) : BaseViewModel() {

    private val _observableActivityStatus = MutableLiveData(false)
    val observableActivityStatus: LiveData<Boolean>
        get() = _observableActivityStatus

    val observableEmail = MutableLiveData<String>()
    val observablePassWord = MutableLiveData<String>()

    private val _observableToast = MutableLiveData<String>()
    val observableToast: LiveData<String>
        get() = _observableToast

    private val _observableGoToSignInPage = MutableLiveData<Boolean>(false)
    val observableGoToSignInPage: LiveData<Boolean>
        get() = _observableGoToSignInPage

    private val _observableGoToSignUpPage = MutableLiveData<Boolean>(false)
    val observableGoToSignUpPage: LiveData<Boolean>
        get() = _observableGoToSignUpPage

    var authListener: AuthListener? = null

    fun login(view: View) {
        if (observableEmail.value.isNullOrEmpty() || observablePassWord.value.isNullOrEmpty()) {
            return
        } else {
            authListener?.onStarted()
            repository.login(
                observableEmail.value!!, observablePassWord.value!!,
                success = {
                    authListener?.onSuccess()
                },
                fail = { e ->
                    e.message?.let { errMsg -> authListener?.onFailure(errMsg) }
                })
        }

    }

    fun register(view: View) {
        if (observableEmail.value.isNullOrEmpty() || observablePassWord.value.isNullOrEmpty()) {
            return
        } else {
            authListener?.onStarted()
            repository.register(observableEmail.value!!,
                observablePassWord.value!!,
                success = {
                    authListener?.onSuccess()
                },
                fail = { e ->
                    e.message?.let { errMsg -> authListener?.onFailure(errMsg) }
                })
        }
    }

    fun sendPw(email: String) {
        authListener?.onStarted()
        repository.sendPwReset(email,
            success = {
                authListener?.onSuccess()
            },
            fail = {e ->
                e.message?.let { errMsg -> authListener?.onFailure(errMsg) }
            })
    }

    fun changeActivityStatus() {
        _observableActivityStatus.value = false
    }


    fun logout() {

    }

    fun currentUser() {

    }

    fun goToSignUp(view: View){
        _observableGoToSignUpPage.value = true
    }

    fun goToSignIn(view: View){
        _observableGoToSignInPage.value = true
    }
}
