package com.suret.taskdesign.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
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

//        main_toolbar.setOnMenuItemClickListener {
//            onOptionsItemSelected(it)
//        }
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

        see_more_tv.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_superFlashSaleFragment)
        }

        mega_see_more_TV.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_superFlashSaleFragment)
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

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.favorite -> findNavController().navigate(R.id.action_home_to_favoriteFragment)
//            R.id.notification -> Log.d("dumb", "dumb")
//        }
//        return super.onOptionsItemSelected(item)
//    }

}
