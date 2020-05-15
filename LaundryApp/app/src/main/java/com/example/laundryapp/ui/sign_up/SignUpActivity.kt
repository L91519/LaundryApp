package com.example.laundryapp.ui.sign_up

import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding, SignUpViewModel>(R.layout.activity_sign_up) {
    override val vm: SignUpViewModel by viewModel<SignUpViewModel>()
}