package com.maktab.amazoonmarkeet.network

import com.maktab.amazonfaraz.model.ProductModel

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("all.json")
    fun getProducts(): Call<List<ProductModel>>
    @GET("mens.json")
    fun getMensProducts(): Call<List<ProductModel>>
    @GET("women.json")
    fun getWomenProducts(): Call<List<ProductModel>>
}