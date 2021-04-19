package com.suret.taskdesign.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.CategoryRecyclerAdapter
import com.suret.taskdesign.adapter.FlashSaleRecyclerAdapter
import com.suret.taskdesign.adapter.ItemPagerAdapter
import com.suret.taskdesign.listmaker.CategoryModelListMaker
import com.suret.taskdesign.listmaker.FlashSaleModelListMaker
import com.suret.taskdesign.listmaker.SalesModelListMaker
import com.suret.taskdesign.model.CategoryModel
import com.suret.taskdesign.model.SalesModel
import com.suret.taskdesign.model.SuperFlashSaleModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var viewPager: ViewPager
    private var salesList: MutableList<SalesModel> = arrayListOf()
    private var categoryList: MutableList<CategoryModel> = arrayListOf()
    private var flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()
    var runnable: Runnable = Runnable { }
    var handler: Handler = Handler(Looper.getMainLooper())

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

        viewPager = view.findViewById(R.id.viewPager)

        val indicator = view.findViewById<TabLayout>(R.id.indicator)

        val itemPagerAdapter = ItemPagerAdapter(salesList)

        val categoryRecycler = view.findViewById<RecyclerView>(R.id.category_recyclerView)
        val flashRecycler = view.findViewById<RecyclerView>(R.id.flash_sale_recycler)
        val megaRecycler = view.findViewById<RecyclerView>(R.id.mega_sale_recycler)

        val categoryAdapter = CategoryRecyclerAdapter(categoryList)
        val flashSaleAdapter = FlashSaleRecyclerAdapter(flashSaleList)

        viewPager.adapter = itemPagerAdapter

        indicator.setupWithViewPager(viewPager)

        sliderTimer(viewPager)

        categoryRecycler.adapter = categoryAdapter

        flashRecycler.adapter = flashSaleAdapter

        megaRecycler.adapter = flashSaleAdapter

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
