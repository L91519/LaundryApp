package com.example.laundryapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.laundryapp.BR

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : RootActivity() {

    protected lateinit var binding: B
    protected abstract val vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
˚
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.setVariable(BR.vm, vm)
        binding.lifecycleOwner = this
    }
}