package com.suret.lafyuu.ui.adapter

import android.app.Activity
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.suret.lafyuu.data.model.Category
import com.suret.lafyuu.databinding.CategoryListLayoutBinding

class CategoryRecyclerAdapter(private val activity: Activity) :
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
                    val uri = Uri.parse("https://svgshare.com/i/ZXc.svg")
                    GlideToVectorYou.justLoadImage(
                        activity,
                        uri,
                        categoryIcon
                    )
//                    categoryIcon.loadImageFromUrl("https://svgshare.com/i/ZXc.svg")
                    categoryTitle.text = it.title
                }
            }
        }
    }

    fun AppCompatImageView.loadImageFromUrl(imageUrl: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry {
                add(SvgDecoder(this@loadImageFromUrl.context))
            }
            .build()

        val imageRequest = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(300)
            .scale(Scale.FIT)
            .transformations(CircleCropTransformation())
            .data(imageUrl)
            .target(
                onStart = {
                    //set up an image loader or whatever you need
                },
                onSuccess = { result ->
                    val bitmap = (result as BitmapDrawable).bitmap
                    this.setImageBitmap(bitmap)
                    //dismiss the loader if any
                },
                onError = {
                    /**
                     *
                     */
                }
            )
            .build()

        imageLoader.enqueue(imageRequest)
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