package com.example.laundryapp.di

import com.example.laundryapp.data.firebase.source.FirebaseSource
import com.example.laundryapp.data.firebase.source.FirebaseSourceImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module

val firebaseModule = module {

    single {
        FirebaseDatabase.getInstance()
    }

    single {
        FirebaseFirestore.getInstance()
    }

    single {
        FirebaseAuth.getInstance()
    }

    single<FirebaseSource> {
        FirebaseSourceImpl(get(), get())
    }
}