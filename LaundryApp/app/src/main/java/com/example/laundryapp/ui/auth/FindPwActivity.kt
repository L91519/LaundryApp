package com.example.laundryapp.ui.auth

import android.os.Bundle
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindPwActivity :
    BaseActivity<ActivitySignInBinding, AuthViewModel>(R.layout.activity_find_pw) {
    override val vm: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
