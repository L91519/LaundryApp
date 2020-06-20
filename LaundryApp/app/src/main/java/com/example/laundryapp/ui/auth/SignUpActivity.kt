package com.example.laundryapp.ui.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignUpBinding
import com.example.laundryapp.extension.showToastShort
import com.example.laundryapp.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity :
    BaseActivity<ActivitySignUpBinding, AuthViewModel>(R.layout.activity_sign_up),
    AuthListener{
    override val vm: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observableProperty()
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

    private fun observableProperty() {
        vm.observableToast.observe(this@SignUpActivity, Observer {
            showToastShort(it)
        })

        vm.observableActivityStatus.observe(this@SignUpActivity, Observer {
            if(it) {
                finish()
                vm.changeActivityStatus()
            }
        })
    }
}