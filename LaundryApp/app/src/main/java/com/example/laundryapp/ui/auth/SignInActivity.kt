package com.example.laundryapp.ui.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import com.example.laundryapp.extension.showToastShort
import kotlinx.android.synthetic.main.activity_find_pw.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity :
    BaseActivity<ActivitySignInBinding, AuthViewModel>(R.layout.activity_sign_in),
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
        //Go to List Activity
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.INVISIBLE
        showToastShort(message)
    }

    private fun observableProperty() {
        vm.observableToast.observe(this@SignInActivity, Observer {
            showToastShort(it)
        })

        vm.observableActivityStatus.observe(this@SignInActivity, Observer {
            if(it){
                finish()
                vm.changeActivityStatus()
            }
        })
    }
}
