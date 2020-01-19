package com.maktab.amazonfaraz.Repository

import androidx.lifecycle.MutableLiveData
import com.maktab.amazonfaraz.model.ProductModel
import com.maktab.amazonfaraz.network.RetrofitInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object Repository {
    var mAllProduct: MutableLiveData<List<ProductModel>>
    var mMensProducts: MutableLiveData<List<ProductModel>>
    var mWomensProducts: MutableLiveData<List<ProductModel>>

    val mApi by lazy {
        RetrofitInstance.create()
    }

    init {
        mAllProduct = MutableLiveData()
        mMensProducts = MutableLiveData()
        mWomensProducts = MutableLiveData()
    }

    fun GetAllProducts(): MutableLiveData<List<ProductModel>> {
        mApi.getProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                if (response.isSuccessful()) {
                    mAllProduct.setValue(response.body()!!)
                } else {
                    mAllProduct.setValue(null)
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                mAllProduct.setValue(null)
            }
        })
        return mAllProduct
    }

    fun getMensProducts(): MutableLiveData<List<ProductModel>> {
        mApi.getMensProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                mMensProducts.setValue(null)
            }

            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                if (response.isSuccessful()) {
                    mMensProducts.setValue(response.body())
                } else {
                    mMensProducts.setValue(response.body())
                }
            }

        })


        return mMensProducts
    }

    fun getWomensProducts(): MutableLiveData<List<ProductModel>> {
        mApi.getWomenProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                mWomensProducts.setValue(null)
            }

            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                if (response.isSuccessful()) {
                    mWomensProducts.setValue(response.body())
                } else {
                    mWomensProducts.setValue(response.body())
                }
            }

        })


        return mWomensProducts
    }

}