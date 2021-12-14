package com.example.jardin.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory {

    private const val  urlAPI = "https://my-json-server.typicode.com/"

    private val okkHttpClient  =  OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

    var retrofit: ApiService = Retrofit.Builder()
        .baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkHttpClient)
        .build()
        .run{
            create(ApiService::class.java)
        }
}