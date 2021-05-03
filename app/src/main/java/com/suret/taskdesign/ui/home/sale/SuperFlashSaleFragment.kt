package com.suret.taskdesign.ui.home.sale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.ItemPagerAdapter
import com.suret.taskdesign.adapter.ProductItemsAdapter
import com.suret.taskdesign.databinding.FragmentSuperFlashSaleBinding
import com.suret.taskdesign.listmaker.FlashSaleModelListMaker
import com.suret.taskdesign.listmaker.SalesModelListMaker
import com.suret.taskdesign.model.SalesModel
import com.suret.taskdesign.model.SuperFlashSaleModel


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