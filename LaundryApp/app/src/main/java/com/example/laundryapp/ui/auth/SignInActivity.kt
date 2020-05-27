package com.example.laundryapp.ui.auth

import android.os.Bundle
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity :
    BaseActivity<ActivitySignInBinding, AuthViewModel>(R.layout.activity_sign_in),
    AuthListener {
    override val vm: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
