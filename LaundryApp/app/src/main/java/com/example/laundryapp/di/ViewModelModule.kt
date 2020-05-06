package com.example.laundryapp.di

import com.example.laundryapp.ui.laundry_add_dialog.LaundryAddDialogViewModel
import com.example.laundryapp.ui.laundry_list.LaundryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LaundryListViewModel(get())
    }

    viewModel {
        LaundryAddDialogViewModel(get())
    }
}