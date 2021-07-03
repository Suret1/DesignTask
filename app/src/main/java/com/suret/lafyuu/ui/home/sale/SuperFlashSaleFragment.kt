package com.suret.lafyuu.ui.home.sale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.lafyuu.R
import com.suret.lafyuu.adapter.ItemPagerAdapter
import com.suret.lafyuu.adapter.ProductItemsAdapter
import com.suret.lafyuu.databinding.FragmentSuperFlashSaleBinding
import com.suret.lafyuu.listmaker.FlashSaleModelListMaker
import com.suret.lafyuu.listmaker.SalesModelListMaker
import com.suret.lafyuu.model.SalesModel
import com.suret.lafyuu.model.SuperFlashSaleModel


class SuperFlashSaleFragment : Fragment() {
    private lateinit var superFlashSaleBinding: FragmentSuperFlashSaleBinding
    private var flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()
    private var salesList: MutableList<SalesModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        superFlashSaleBinding = FragmentSuperFlashSaleBinding.inflate(inflater, container, false)
        return superFlashSaleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flashSaleList = FlashSaleModelListMaker.flashSaleListMaker()
        salesList = SalesModelListMaker.salesListMaker()

        salesList.removeFirstOrNull()

        salesList.removeLastOrNull()

        val flashSaleAdapter = ProductItemsAdapter(flashSaleList)
        val itemPagerAdapter = ItemPagerAdapter(salesList)


        superFlashSaleBinding.apply {
            superFlashSaleRecycler.adapter = flashSaleAdapter
            flashSaleViewPager.adapter = itemPagerAdapter
            flashSaleToolbar.setNavigationIcon(R.drawable.back_btn)
            flashSaleToolbar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }


    }

}