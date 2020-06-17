package com.example.laundryapp.ui.auth

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import com.example.laundryapp.extension.showToastShort
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity :
    BaseActivity<ActivitySignInBinding, AuthViewModel>(R.layout.activity_sign_in),
    AuthListener {
    override val vm: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observableProperty()
    }

    override fun onStarted() {
        TODO("Not yet implemented")
        //Show Progress Bar
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
        //Hide Progress Bar
        //Go to List Activity
    }

    override fun onFailure(message: String) {
        TODO("Not yet implemented")
        //Hide Progress Bar
        //Show Toast
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
