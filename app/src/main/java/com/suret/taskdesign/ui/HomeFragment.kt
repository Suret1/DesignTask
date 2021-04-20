package com.suret.taskdesign.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.CategoryRecyclerAdapter
import com.suret.taskdesign.adapter.FlashSaleRecyclerAdapter
import com.suret.taskdesign.adapter.ItemPagerAdapter
import com.suret.taskdesign.adapter.ProductItemsAdapter
import com.suret.taskdesign.listmaker.CategoryModelListMaker
import com.suret.taskdesign.listmaker.FlashSaleModelListMaker
import com.suret.taskdesign.listmaker.SalesModelListMaker
import com.suret.taskdesign.model.CategoryModel
import com.suret.taskdesign.model.SalesModel
import com.suret.taskdesign.model.SuperFlashSaleModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var salesList: MutableList<SalesModel> = arrayListOf()
    private var categoryList: MutableList<CategoryModel> = arrayListOf()
    private var flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()
    private var runnable: Runnable = Runnable { }
    private var handler: Handler = Handler(Looper.getMainLooper())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.status_bar_night,
            R.color.white
        )
        salesList = SalesModelListMaker.salesListMaker()

        categoryList = CategoryModelListMaker.categoryListMaker()

        flashSaleList = FlashSaleModelListMaker.flashSaleListMaker()

        val itemPagerAdapter = ItemPagerAdapter(salesList)

        val categoryAdapter = CategoryRecyclerAdapter(categoryList)
        val flashSaleAdapter = FlashSaleRecyclerAdapter(flashSaleList)
        val gridAdapter = ProductItemsAdapter(flashSaleList)

        viewPager.adapter = itemPagerAdapter

        indicator.setupWithViewPager(viewPager)

        sliderTimer(viewPager)

        category_recyclerView.adapter = categoryAdapter

        flash_sale_recycler.adapter = flashSaleAdapter

        mega_sale_recycler.adapter = flashSaleAdapter

        grid_recycler.adapter = gridAdapter

        more_category_TV.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
        }

    }

    private fun sliderTimer(viewPager: ViewPager) {
        runnable = object : Runnable {
            override fun run() {
                if (viewPager.currentItem < salesList.size - 1) {
                    viewPager.currentItem = viewPager.currentItem + 1
                } else {
                    viewPager.currentItem = 0
                }
                handler.postDelayed(this, 3000)
            }
        }
        handler.post(runnable)
    }
}
