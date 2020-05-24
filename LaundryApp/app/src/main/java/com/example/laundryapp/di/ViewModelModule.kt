package com.example.laundryapp.di

import com.example.laundryapp.ui.laundry_add_dialog.LaundryAddDialogViewModel
import com.example.laundryapp.ui.laundry_list.LaundryListViewModel
import com.example.laundryapp.ui.auth.sign_in.SignInViewModel
import com.example.laundryapp.ui.auth.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LaundryListViewModel(get())
    }

    viewModel {
        LaundryAddDialogViewModel(get())
    }

    viewModel {
        SignInViewModel()
    }

    viewModel {
        SignUpViewModel()
    }
}