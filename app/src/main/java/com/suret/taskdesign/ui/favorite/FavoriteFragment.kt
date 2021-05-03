package com.suret.taskdesign.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.ProductItemsAdapter
import com.suret.taskdesign.databinding.FragmentFavoriteBinding
import com.suret.taskdesign.listmaker.FlashSaleModelListMaker
import com.suret.taskdesign.model.SuperFlashSaleModel


class FavoriteFragment : Fragment() {
    private lateinit var favoriteBinding: FragmentFavoriteBinding
    private var favoriteList: MutableList<SuperFlashSaleModel> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return favoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteList = FlashSaleModelListMaker.flashSaleListMaker()

        val favoriteAdapter = ProductItemsAdapter(favoriteList)


        favoriteBinding.apply {
            favoriteRecycler.adapter = favoriteAdapter

            favoriteToolbar.setNavigationIcon(R.drawable.back_btn)

            favoriteToolbar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }


    }


}