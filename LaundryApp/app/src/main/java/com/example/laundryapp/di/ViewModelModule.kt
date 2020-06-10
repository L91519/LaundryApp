package com.example.laundryapp.di

import com.example.laundryapp.ui.auth.AuthViewModel
import com.example.laundryapp.ui.laundry_list.LaundryListViewModel
import com.example.laundryapp.ui.laundry_list.laundry_add_dialog.LaundryListAddViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AuthViewModel(get())
    }

    viewModel {
        LaundryListViewModel(get())
    }

    viewModel {
        LaundryListAddViewModel(get())
    }
}