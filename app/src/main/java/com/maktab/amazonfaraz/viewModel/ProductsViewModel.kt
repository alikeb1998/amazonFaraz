package com.maktab.amazonfaraz.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.maktab.amazonfaraz.Repository.Repository
import com.maktab.amazonfaraz.model.ProductModel


class ProductsViewModel : AndroidViewModel {
    var mAllProduct: MutableLiveData<List<ProductModel>>? = null
    var mMensProducts: MutableLiveData<List<ProductModel>>? = null
    var mWomensProducts: MutableLiveData<List<ProductModel>>? = null

    constructor(application: Application) : super(application)

    init {
        mAllProduct = Repository.mAllProduct
        mMensProducts = Repository.mMensProducts
        mWomensProducts = Repository.mWomensProducts
    }

    fun loadAllProduct() {
        Repository.GetAllProducts()
    }

    fun loadMensProducts() {
        Repository.getMensProducts()
    }

    fun loadWomensProduct() {
        Repository.getWomensProducts()
    }


}