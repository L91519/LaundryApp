package com.example.laundryapp.ui.auth.sign_in

import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity :
    BaseActivity<ActivitySignInBinding, SignInViewModel>(R.layout.activity_sign_in) {
    override val vm: SignInViewModel by viewModel<SignInViewModel>()
}
