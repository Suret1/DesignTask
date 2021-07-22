package com.suret.lafyuu.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.suret.lafyuu.R
import com.suret.lafyuu.data.model.test.SuperFlashSaleModel

class ProductItemsAdapter(private val productList: MutableList<SuperFlashSaleModel>) :
    RecyclerView.Adapter<ProductItemsAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.flash_sale_IW)
        val textTitle: TextView = itemView.findViewById(R.id.flash_sale_product_title)
        val textPrice: TextView = itemView.findViewById(R.id.flash_sale_product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.product_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.load(productList[position].sale_url_image)
        holder.textTitle.text = productList[position].saleTitle
        holder.textPrice.text = productList[position].salePrice
    }
    override fun getItemCount(): Int = productList.size
}

