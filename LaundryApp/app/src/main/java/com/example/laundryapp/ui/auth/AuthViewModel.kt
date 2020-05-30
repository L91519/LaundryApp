package com.example.laundryapp.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.ui.laundry_list.LaundryListActivity

class AuthViewModel constructor(private val repository: FirebaseRepository) : BaseViewModel() {

//    private val _observableEmail = MutableLiveData<String>()
//    val observableEmail : LiveData<String>
//        get() = _observableEmail

//    private val _observablePassWord = MutableLiveData<String>()
//    val observablePassWord : LiveData<String>
//        get() = _observablePassWord

    val _observableEmail = MutableLiveData<String>()
    val _observablePassWord = MutableLiveData<String>()

    private val _observableToast = MutableLiveData<String>()
    val observableToast : LiveData<String>
        get() = _observableToast

    private val _observableIsLoginPage = MutableLiveData<Boolean>(true)
    val observableIsLoginPage : LiveData<Boolean>
        get() = _observableIsLoginPage

    fun login(view: View) {
        if(_observableEmail.value.isNullOrEmpty() || _observablePassWord.value.isNullOrEmpty()){
            return
        }
        else {
            repository.login(_observableEmail.value!!, _observablePassWord.value!!,
                success = {
                    Intent(view.context, LaundryListActivity::class.java).also {
                        view.context.startActivity(it)
                    }
                },
                fail = {
                    _observableToast.value = "Login Failed"
                })
        }

    }

    fun register(view: View) {
        if(_observableEmail.value.isNullOrEmpty() || _observablePassWord.value.isNullOrEmpty()){
            return
        }
        else {
            repository.register(_observableEmail.value!!,
                _observablePassWord.value!!,
                success = {
                    Intent(view.context, SignInActivity::class.java).also {
                        view.context.startActivity(it)
                    }
                },
                fail = {
                    _observableToast.value = "Sign In Failed"
                })
        }
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
