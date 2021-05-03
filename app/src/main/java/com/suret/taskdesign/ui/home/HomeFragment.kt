package com.suret.taskdesign.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.CategoryRecyclerAdapter
import com.suret.taskdesign.adapter.FlashSaleRecyclerAdapter
import com.suret.taskdesign.adapter.ItemPagerAdapter
import com.suret.taskdesign.adapter.ProductItemsAdapter
import com.suret.taskdesign.databinding.FragmentHomeBinding
import com.suret.taskdesign.listmaker.CategoryModelListMaker
import com.suret.taskdesign.listmaker.FlashSaleModelListMaker
import com.suret.taskdesign.listmaker.SalesModelListMaker
import com.suret.taskdesign.model.CategoryModel
import com.suret.taskdesign.model.SalesModel
import com.suret.taskdesign.model.SuperFlashSaleModel


class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private var salesList: MutableList<SalesModel> = arrayListOf()
    private var categoryList: MutableList<CategoryModel> = arrayListOf()
    private var flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()
    private var runnable: Runnable = Runnable { }
    private var handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        salesList = SalesModelListMaker.salesListMaker()

        categoryList = CategoryModelListMaker.categoryListMaker()

        flashSaleList = FlashSaleModelListMaker.flashSaleListMaker()

        val itemPagerAdapter = ItemPagerAdapter(salesList)

        val categoryAdapter = CategoryRecyclerAdapter(categoryList)
        val flashSaleAdapter = FlashSaleRecyclerAdapter(flashSaleList)
        val gridAdapter = ProductItemsAdapter(flashSaleList)


        homeBinding.apply {

            viewPager.adapter = itemPagerAdapter

            indicator.setupWithViewPager(viewPager)

            sliderTimer(viewPager)


            categoryRecyclerView.adapter = categoryAdapter

            flashSaleRecycler.adapter = flashSaleAdapter

            megaSaleRecycler.adapter = flashSaleAdapter

            gridRecycler.adapter = gridAdapter

            moreCategoryTV.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_nestedFragment_to_categoryFragment)
            }

            seeMoreTv.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_nestedFragment_to_superFlashSaleFragment)
            }

            megaSeeMoreTV.setOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.action_nestedFragment_to_superFlashSaleFragment)
            }
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
