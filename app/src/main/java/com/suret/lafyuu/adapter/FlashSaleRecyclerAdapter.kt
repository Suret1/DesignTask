package com.suret.lafyuu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.suret.lafyuu.R
import com.suret.lafyuu.model.SuperFlashSaleModel

class FlashSaleRecyclerAdapter(private val flashList: MutableList<SuperFlashSaleModel>) :
    RecyclerView.Adapter<FlashSaleRecyclerAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.flash_sale_IW)
        val textTitle: TextView = itemView.findViewById(R.id.flash_sale_product_title)
        val textPrice: TextView = itemView.findViewById(R.id.flash_sale_product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.flash_sale_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.load(flashList[position].sale_url_image)
        holder.textTitle.text = flashList[position].saleTitle
        holder.textPrice.text = flashList[position].salePrice
    }
    override fun getItemCount(): Int = 4
}