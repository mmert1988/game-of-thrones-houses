package com.mehmedmert.gameofthroneshouses.network.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object IceAndFireApiRetrofitClient {
    var retrofitClient: Retrofit? = null
    fun getInstance(): Retrofit {
        if (retrofitClient == null) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
            retrofitClient = Retrofit.Builder()
                .baseUrl("https://anapioficeandfire.com/api")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        return retrofitClient!!
    }
}
