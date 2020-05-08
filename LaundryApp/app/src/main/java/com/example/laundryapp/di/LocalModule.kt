package com.example.laundryapp.di

import androidx.room.Room
import com.example.laundryapp.data.source.local.LaundryLocalDataSource
import com.example.laundryapp.data.source.local.LaundryLocalDataSourceImpl
import com.example.laundryapp.data.source.local.db.LaundryDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {

    factory {
        Room.databaseBuilder(
            androidContext(),
            LaundryDataBase::class.java,
        "Laundries.db"
        ).allowMainThreadQueries().build()
    }

    single {
        get<LaundryDataBase>().laundryDao()
    }

    single<LaundryLocalDataSource> {
        LaundryLocalDataSourceImpl(get())
    }
}