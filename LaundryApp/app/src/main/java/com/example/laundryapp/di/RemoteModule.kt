package com.example.laundryapp.di

import com.example.laundryapp.data.source.remote.LaundryRemoteDataSource
import com.example.laundryapp.data.source.remote.LaundryRemoteDataSourceImpl
import com.example.laundryapp.data.source.remote.network.LaundryApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT: Long = 15
private const val BASE_URL = "https://openapi.naver.com/v1/"


val remoteModule = module {

    factory {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient().newBuilder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    single { GsonConverterFactory.create() as Converter.Factory }

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(get())
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        get<Retrofit>().create(LaundryApi::class.java)
    }

    single<LaundryRemoteDataSource> {
        LaundryRemoteDataSourceImpl(get())
    }
}