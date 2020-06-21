package com.example.laundryapp.ui.auth

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivitySignInBinding
import com.example.laundryapp.extension.showToastShort
import com.example.laundryapp.ui.laundry_list.LaundryListActivity
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
        goToList()
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.INVISIBLE
        showToastShort(message)
    }

    private fun goToSignUp() {
        Intent(applicationContext, SignUpActivity::class.java).also {
            applicationContext.startActivity(it.addFlags(FLAG_ACTIVITY_NEW_TASK))
        }
        finish()
    }

    private fun goToList() {
        Intent(applicationContext, LaundryListActivity::class.java).also {
            applicationContext.startActivity(it.addFlags(FLAG_ACTIVITY_NEW_TASK))
        }
        finish()
    }
    private fun observableProperty() {
        vm.observableToast.observe(this@SignInActivity, Observer {
            showToastShort(it)
        })

        vm.observableGoToSignUpPage.observe(this@SignInActivity, Observer { isGoToSignUp ->
            if (isGoToSignUp) {
                goToSignUp()
            }
        })
    }
}
