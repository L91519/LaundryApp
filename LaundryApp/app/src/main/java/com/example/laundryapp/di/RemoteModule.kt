package com.example.laundryapp.di

import com.example.laundryapp.data.source.remote.LaundryRemoteDataSourceImpl
import com.example.laundryapp.data.source.remote.network.LaundryApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://openapi.naver.com/v1/"
private const val TIMEOUT: Long = 15

val remoteModule = module {

    factory {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient().newBuilder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(LaundryApi::class.java)
    }

    single {
        LaundryRemoteDataSourceImpl(get())
    }
}