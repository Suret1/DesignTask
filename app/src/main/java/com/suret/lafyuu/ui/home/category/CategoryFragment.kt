package com.suret.lafyuu.ui.home.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.lafyuu.R
import com.suret.lafyuu.adapter.FragmentCategoryRecyclerAdapter
import com.suret.lafyuu.databinding.FragmentCategoryBinding
import com.suret.lafyuu.listmaker.CategoryModelListMaker
import com.suret.lafyuu.model.CategoryModel


class CategoryFragment : Fragment() {
    private lateinit var categoryBinding: FragmentCategoryBinding
    private var categoryList: MutableList<CategoryModel> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryBinding = FragmentCategoryBinding.inflate(inflater, container, false)
        return categoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryBinding.apply {

            categoryToolbar.setNavigationIcon(R.drawable.back_btn)

            categoryToolbar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            categoryList = CategoryModelListMaker.categoryListMaker()
            val fragmentCategoryRecyclerAdapter =
                FragmentCategoryRecyclerAdapter(categoryList)

            categoryBinding.recyclerViewCategory.adapter = fragmentCategoryRecyclerAdapter

        }


    }


}