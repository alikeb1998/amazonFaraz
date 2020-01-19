package com.maktab.amazonfaraz.network

import com.maktab.amazoonmarkeet.network.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASE_URL = "https://s3-ap-northeast-1.amazonaws.com/m-et/Android/json/"
    lateinit var retrofitInstance: Retrofit
    val okHttpClient = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor()

    init {
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(logging)
    }
    fun create(): Api {
        retrofitInstance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
      return  retrofitInstance.create(Api::class.java)
    }

}