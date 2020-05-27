package com.example.laundryapp.ui.auth

import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignUpBinding
import com.example.laundryapp.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding, AuthViewModel>(R.layout.activity_sign_up),
    AuthListener{
    override val vm: AuthViewModel by viewModel<AuthViewModel>()

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String) {
        TODO("Not yet implemented")
    }
}