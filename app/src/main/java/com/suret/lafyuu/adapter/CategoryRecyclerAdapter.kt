package com.suret.lafyuu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suret.lafyuu.R
import com.suret.lafyuu.model.CategoryModel

class CategoryRecyclerAdapter(
    private val categoryList: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryIcon: ImageView = itemView.findViewById(R.id.category_icon)
        val categoryTitle: TextView = itemView.findViewById(R.id.category_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.category_list_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.categoryIcon.setImageResource(categoryList[position].categoryIcon)
        holder.categoryTitle.text =
            (holder.itemView.context.resources.getString(categoryList[position].categoryTitle))

    }

    override fun getItemCount(): Int = categoryList.size

}