package com.suret.taskdesign.ui.category

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.FragmentCategoryRecyclerAdapter
import com.suret.taskdesign.listmaker.CategoryModelListMaker
import com.suret.taskdesign.model.CategoryModel
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment(R.layout.fragment_category) {

    private var categoryList: MutableList<CategoryModel> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryList = CategoryModelListMaker.categoryListMaker()

        category_toolbar.setNavigationIcon(R.drawable.back_btn)


        category_toolbar.setNavigationOnClickListener {
            view.findNavController().navigate(R.id.action_categoryFragment_to_homeFragment)
        }

        val fragmentCategoryRecyclerAdapter =
            FragmentCategoryRecyclerAdapter(categoryList)

        recyclerView_category.adapter = fragmentCategoryRecyclerAdapter


    }



}