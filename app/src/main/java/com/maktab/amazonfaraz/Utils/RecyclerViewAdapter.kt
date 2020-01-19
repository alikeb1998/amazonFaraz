package com.maktab.amazonfaraz.Utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maktab.amazonfaraz.R
import com.maktab.amazonfaraz.model.ProductModel

import com.squareup.picasso.Picasso

class RecyclerViewAdapter(val context: Context, var productList: List<ProductModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.list_recycle_products, parent, false)
        val viewHolder = ViewHolder(view, context)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList.get(position))
    }


    class ViewHolder(view: View, val context: Context) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.productName)
        private val image: ImageView = view.findViewById(R.id.list_newest_product_image_view1)
        private val price: TextView = view.findViewById(R.id.textViewPrice)
        private val likes: TextView = view.findViewById(R.id.texViewLike)
        private val comments: TextView = view.findViewById(R.id.textViewComment)
        private val isSold: TextView = view.findViewById(R.id.textViewSelling)
        private var mProduct: ProductModel? = null
        fun bind(product: ProductModel) {
            mProduct = product
            name.setText(product.name)
            price.text = product.price.toString()
            likes.text = product.num_likes.toString()
            comments.text = product.num_comments.toString()
            if (product.status == "sold_out") {
                isSold.visibility = View.VISIBLE
                isSold.text = "فروخته شد"
            }
            Picasso.with(context).load(product.photo).placeholder(R.drawable.amazonplace)
                .into(image)

        }
    }


}