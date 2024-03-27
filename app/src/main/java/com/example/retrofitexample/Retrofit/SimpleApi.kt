package com.example.retrofitexample.Retrofit

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface SimpleApi {
    @GET("api/activity")
    suspend fun getdata():Mypost
}

data class Mypost(
    val activity: String,



)