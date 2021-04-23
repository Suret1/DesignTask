package com.suret.taskdesign.ui.explore

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.CategoryRecyclerAdapter
import com.suret.taskdesign.listmaker.CategoryModelListMaker
import com.suret.taskdesign.model.CategoryModel
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment(R.layout.fragment_explore) {
    private var categoryForMan: MutableList<CategoryModel> = arrayListOf()
    private var categoryForWoman: MutableList<CategoryModel> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryForMan = CategoryModelListMaker.categoryListForMan()
        categoryForWoman = CategoryModelListMaker.categoryListForWoman()

        val manAdapter = CategoryRecyclerAdapter(categoryForMan)
        man_fashion_recycler.adapter = manAdapter
        val womanAdapter = CategoryRecyclerAdapter(categoryForWoman)
        woman_fashion_recycler.adapter = womanAdapter

    }



}