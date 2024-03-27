package com.example.retrofitexample.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofitinstance {
    //https://www.boredapi.com/api/activity
    private val  retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    }
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}