package com.suret.lafyuu.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.suret.lafyuu.data.model.Category
import com.suret.lafyuu.databinding.CategoryListLayoutBinding

class CategoryRecyclerAdapter :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem.categoryId == newItem.categoryId
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class CategoryViewHolder(private val categoryListLayoutBinding: CategoryListLayoutBinding) :
        RecyclerView.ViewHolder(categoryListLayoutBinding.root) {
        fun bind(category: Category?) {
            categoryListLayoutBinding.apply {
                category?.let {
                    categoryIcon.load(it.icon)
                    categoryTitle.text = it.title
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryRecyclerAdapter.CategoryViewHolder {
        return CategoryViewHolder(
            CategoryListLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: CategoryRecyclerAdapter.CategoryViewHolder,
        position: Int
    ) {
        holder.bind(differ.currentList.getOrNull(position))
    }

    override fun getItemCount(): Int = differ.currentList.size

}