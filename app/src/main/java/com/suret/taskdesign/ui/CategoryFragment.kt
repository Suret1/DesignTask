package com.suret.taskdesign.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.FragmentCategoryRecyclerAdapter
import com.suret.taskdesign.model.CategoryModel
import com.suret.taskdesign.model.CategoryModelListMaker


class CategoryFragment : Fragment(R.layout.fragment_category) {
    private var categoryList: MutableList<CategoryModel> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.status_bar_night,
            R.color.white
        )

        categoryList = CategoryModelListMaker.categoryListMaker()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_category)
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.back_btn)


        toolbar.setOnClickListener {
            view.findNavController().navigate(R.id.action_categoryFragment_to_homeFragment)
        }

        val fragmentCategoryRecyclerAdapter =
            FragmentCategoryRecyclerAdapter(categoryList)

        recyclerView.adapter = fragmentCategoryRecyclerAdapter

    }

}