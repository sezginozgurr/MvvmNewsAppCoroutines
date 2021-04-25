package com.example.mvvmturkeynews.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        val BASE_URL = "https://newsapi.org/v2/"

        @Volatile //Singleton yapısına uygun olması için.. Farklı 2 thread aynı anda çalışmasın diye
        private var INSTANCE: Retrofit? = null

        fun getRetrofit(): Retrofit {
            synchronized(this) { //Senkron çalışması için
                INSTANCE?.let {
                    return it
                }
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return INSTANCE as Retrofit
            }
        }
    }
}