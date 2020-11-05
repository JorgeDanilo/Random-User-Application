package com.example.randomuserapplication.app.config

import com.example.randomuserapplication.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_URL = "https://randomuser.me/api/"

const val CONNECTION_TIMEOUT = 60000L

internal fun provideOkHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .writeTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)
    }

    return client.build()
}

fun provideGson(): Gson {
    val gson = GsonBuilder()
        .setDateFormat("dd/MM/yyyy HH:mm")
        .setLenient()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    return gson
}


internal fun provideRetrofit(factory: Gson, okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(API_URL)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create(factory))
    .client(okHttpClient)
    .build()

internal inline fun <reified T> createApi(retrofit: Retrofit) = retrofit.create(T::class.java)