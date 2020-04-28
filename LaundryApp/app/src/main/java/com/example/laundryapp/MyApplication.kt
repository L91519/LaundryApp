package com.example.laundryapp

import android.app.Application
import com.example.laundryapp.di.localModule
import com.example.laundryapp.di.remoteModule
import com.example.laundryapp.di.repositoryModule
import com.example.laundryapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    localModule,
                    remoteModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}