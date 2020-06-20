package com.example.laundryapp.ui.auth

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignUpBinding
import com.example.laundryapp.extension.showToastShort
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding, AuthViewModel>(R.layout.activity_sign_up),
    AuthListener {
    override val vm: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.authListener = this
        observableProperty()
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.INVISIBLE
        goToSignIn()

    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.INVISIBLE
        showToastShort(message)
    }

    private fun goToSignIn(){
        Intent(applicationContext, SignInActivity::class.java).also {
            applicationContext.startActivity(it.addFlags(FLAG_ACTIVITY_NEW_TASK))
        }
        finish()
    }

    private fun observableProperty() {
        vm.observableToast.observe(this@SignUpActivity, Observer {
            showToastShort(it)
        })

        vm.observableGoToSignInPage.observe(this@SignUpActivity, Observer {isGoToSignIn ->
            if(isGoToSignIn){
                goToSignIn()
            }
        })
    }
}