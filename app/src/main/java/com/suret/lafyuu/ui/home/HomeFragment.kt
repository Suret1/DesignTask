package com.suret.lafyuu.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.suret.lafyuu.R
import com.suret.lafyuu.ui.adapter.CategoryRecyclerAdapter
import com.suret.lafyuu.ui.adapter.FlashSaleRecyclerAdapter
import com.suret.lafyuu.ui.adapter.ItemPagerAdapter
import com.suret.lafyuu.ui.adapter.ProductItemsAdapter
import com.suret.lafyuu.databinding.FragmentHomeBinding
import com.suret.lafyuu.listmaker.CategoryModelListMaker
import com.suret.lafyuu.listmaker.FlashSaleModelListMaker
import com.suret.lafyuu.listmaker.SalesModelListMaker
import com.suret.lafyuu.data.model.test.CategoryModel
import com.suret.lafyuu.data.model.test.SalesModel
import com.suret.lafyuu.data.model.test.SuperFlashSaleModel
import com.suret.lafyuu.util.Utils


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

        Utils.hideKeyboard(requireActivity())

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
