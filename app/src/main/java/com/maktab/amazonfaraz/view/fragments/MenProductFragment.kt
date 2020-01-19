package com.maktab.amazonfaraz.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.maktab.amazonfaraz.R
import com.maktab.amazonfaraz.Utils.RecyclerViewAdapter
import com.maktab.amazonfaraz.model.ProductModel
import com.maktab.amazonfaraz.viewModel.ProductsViewModel


class MenProductFragment : Fragment() {

    private lateinit var mRecyclerViewMensProduct: RecyclerView
    private lateinit var mViewModel: ProductsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)
        mViewModel.loadMensProducts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_men_product, container, false)

        mRecyclerViewMensProduct = view.findViewById(R.id.mensProductRecycle)
        val mensProductObserver = Observer<List<ProductModel>> {

            initRecyclerView(it)

        }
        mViewModel.mAllProduct?.observe(this, mensProductObserver)
        return view
    }

    fun initRecyclerView(productList: List<ProductModel>) {

        mRecyclerViewMensProduct.layoutManager = GridLayoutManager(activity, 2)
        val adapter = RecyclerViewAdapter(context!!, productList)
        mRecyclerViewMensProduct.adapter = adapter
    }


}
