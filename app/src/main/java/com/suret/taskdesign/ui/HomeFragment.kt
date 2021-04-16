package com.suret.taskdesign.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.ItemPagerAdapter
import com.suret.taskdesign.model.SalesModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var viewPager: ViewPager
    val list: MutableList<SalesModel> = arrayListOf()
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
        list.add(
            SalesModel(
                "https://cutt.ly/Ec49wPk",
                "Nike Sale",
                9607780
            )
        )
        list.add(
            SalesModel(
                "https://cutt.ly/dc49tUC",
                "Air Max Sale",
                9685485
            )
        )
        list.add(
            SalesModel(
                "https://cutt.ly/sc49u0i",
                "Adidas Sale",
                12854561
            )
        )

        viewPager = view.findViewById(R.id.viewPager)
        val indicator = view.findViewById<TabLayout>(R.id.indicator)
        val itemPagerAdapter = ItemPagerAdapter(list)

        viewPager.adapter = itemPagerAdapter

        indicator.setupWithViewPager(viewPager)

        sliderTimer(viewPager)

    }

    private fun sliderTimer(viewPager: ViewPager) {
        runnable = object : Runnable {
            override fun run() {
                if (viewPager.currentItem < list.size - 1) {
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
