package com.example.laundryapp.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.ui.laundry_list.LaundryListActivity

class AuthViewModel constructor(private val repository: FirebaseRepository) : BaseViewModel() {

    private val _observableActivityStatus = MutableLiveData(false)
    val observableActivityStatus: LiveData<Boolean>
        get() = _observableActivityStatus

    val observableEmail = MutableLiveData<String>()
    val observablePassWord = MutableLiveData<String>()

    private val _observableToast = MutableLiveData<String>()
    val observableToast: LiveData<String>
        get() = _observableToast

    private val _observableIsLoginPage = MutableLiveData<Boolean>(true)
    val observableIsLoginPage: LiveData<Boolean>
        get() = _observableIsLoginPage

    var authListener: AuthListener? = null

    fun login(view: View) {
        if (observableEmail.value.isNullOrEmpty() || observablePassWord.value.isNullOrEmpty()) {
            return
        } else {
            authListener?.onStarted()
            repository.login(observableEmail.value!!, observablePassWord.value!!,
                success = {
                    Intent(view.context, LaundryListActivity::class.java).also {
                        view.context.startActivity(it)
                        _observableActivityStatus.value = true
                    }
                },
                fail = {e ->
                    authListener?.onFailure(e.toString())
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
                    Intent(view.context, SignInActivity::class.java).also {
                        view.context.startActivity(it)
                    }
                },
                fail = { e ->
                    authListener?.onFailure(e.toString())
                })
        }
    }

    fun sendPw(email: String) {
        authListener?.onStarted()
        repository.sendPwReset(email,
            success = {

            },
            fail = {e ->
                authListener?.onFailure(e.toString())

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
        Intent(view.context, SignUpActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun goToLogin(view: View){
        Intent(view.context, SignInActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}
