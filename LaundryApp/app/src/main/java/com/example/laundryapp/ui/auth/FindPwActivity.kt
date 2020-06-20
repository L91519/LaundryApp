package com.example.laundryapp.ui.auth

import android.os.Bundle
import android.view.View
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import com.example.laundryapp.extension.showToastShort
import com.example.laundryapp.ui.auth.AuthListener
import com.example.laundryapp.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindPwActivity :
    BaseActivity<ActivitySignInBinding, AuthViewModel>(R.layout.activity_find_pw),
    AuthListener {
    override val vm: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.INVISIBLE
        //Go to List Activity
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.INVISIBLE
        showToastShort(message)
    }

}
