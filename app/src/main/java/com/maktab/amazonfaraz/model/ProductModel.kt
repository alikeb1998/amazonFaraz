package com.maktab.amazonfaraz.model

import com.google.gson.annotations.SerializedName

data class ProductModel(
        @SerializedName("photo")
        val photo:String,
        @SerializedName("name")
        val name:String,
        @SerializedName("id")
        val id:String,
        @SerializedName("status")
        val status:String,
        @SerializedName("price")
        val price:Int,
        @SerializedName("num_comments")
        val num_comments:Int,
        @SerializedName("num_likes")
        val num_likes:Int
)