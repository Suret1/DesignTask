package com.suret.taskdesign.ui.sale

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.ItemPagerAdapter
import com.suret.taskdesign.adapter.ProductItemsAdapter
import com.suret.taskdesign.listmaker.FlashSaleModelListMaker
import com.suret.taskdesign.listmaker.SalesModelListMaker
import com.suret.taskdesign.model.SalesModel
import com.suret.taskdesign.model.SuperFlashSaleModel
import kotlinx.android.synthetic.main.fragment_super_flash_sale.*


class SuperFlashSaleFragment : Fragment(R.layout.fragment_super_flash_sale) {
    private var flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()
    private var salesList: MutableList<SalesModel> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flashSaleList = FlashSaleModelListMaker.flashSaleListMaker()
        salesList = SalesModelListMaker.salesListMaker()

        salesList.removeFirstOrNull()

        salesList.removeLastOrNull()

        val flashSaleAdapter = ProductItemsAdapter(flashSaleList)
        val itemPagerAdapter = ItemPagerAdapter(salesList)

        super_flash_sale_recycler.adapter = flashSaleAdapter
        flash_sale_viewPager.adapter = itemPagerAdapter

        flash_sale_toolbar.setNavigationIcon(R.drawable.back_btn)

        flash_sale_toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }


    }

}