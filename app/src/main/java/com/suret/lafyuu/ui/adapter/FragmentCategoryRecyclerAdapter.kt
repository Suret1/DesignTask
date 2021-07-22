package com.suret.lafyuu.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.suret.lafyuu.R
import com.suret.lafyuu.data.model.test.CategoryModel

class FragmentCategoryRecyclerAdapter(private val categoryList: MutableList<CategoryModel>) :
    RecyclerView.Adapter<FragmentCategoryRecyclerAdapter.MyFragmentViewHolder>() {

    inner class MyFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryButton: Button = itemView.findViewById(R.id.category_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFragmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.category_list_of_fragment, parent, false)
        return MyFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyFragmentViewHolder, position: Int) {
        holder.categoryButton.setCompoundDrawablesWithIntrinsicBounds(
            categoryList[position].categoryIcon,
            0,
            0,
            0,
        )
        holder.categoryButton.text =
            (holder.itemView.resources.getString(categoryList[position].categoryTitle))
    }

    override fun getItemCount(): Int = categoryList.size
}
