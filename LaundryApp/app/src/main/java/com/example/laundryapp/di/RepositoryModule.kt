package com.example.laundryapp.di

import com.example.laundryapp.data.repository.LaundryAppRepository
import com.example.laundryapp.data.repository.LaundryAppRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LaundryAppRepository> {
        LaundryAppRepositoryImpl(get(), get())
    }
}
