package com.suret.lafyuu.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.suret.lafyuu.R
import com.suret.lafyuu.data.model.Advertisment
import com.suret.lafyuu.data.model.test.CategoryModel
import com.suret.lafyuu.data.model.test.SalesModel
import com.suret.lafyuu.data.model.test.SuperFlashSaleModel
import com.suret.lafyuu.databinding.FragmentHomeBinding
import com.suret.lafyuu.ui.adapter.CategoryRecyclerAdapter
import com.suret.lafyuu.ui.adapter.FlashSaleRecyclerAdapter
import com.suret.lafyuu.ui.adapter.ItemPagerAdapter
import com.suret.lafyuu.ui.adapter.ProductItemsAdapter
import com.suret.lafyuu.ui.home.viewmodel.HomeViewModel
import com.suret.lafyuu.util.Constants.SETTINGS_PREF
import com.suret.lafyuu.util.Constants.TOKEN
import com.suret.lafyuu.util.PopUps
import com.suret.lafyuu.util.PreferenceHelper
import com.suret.lafyuu.util.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private var salesList: MutableList<SalesModel> = arrayListOf()
    private var categoryList: MutableList<CategoryModel> = arrayListOf()
    private var flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()
    private var runnable: Runnable = Runnable { }
    private var handler: Handler = Handler(Looper.getMainLooper())
    private var token: String? = null

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Utils.hideKeyboard(requireActivity())
//
//        salesList = SalesModelListMaker.salesListMaker()
//
//        categoryList = CategoryModelListMaker.categoryListMaker()
//
//        flashSaleList = FlashSaleModelListMaker.flashSaleListMaker()


        val categoryAdapter = CategoryRecyclerAdapter()
        val flashSaleAdapter = FlashSaleRecyclerAdapter(flashSaleList)
        val gridAdapter = ProductItemsAdapter(flashSaleList)

        val progressBar = PopUps.progressDialog(requireActivity())

        homeBinding.apply {

            categoryRecyclerView.adapter = categoryAdapter
            token = PreferenceHelper.customPrefs(requireContext(), SETTINGS_PREF)
                .getString(TOKEN, "")

            token?.let {
                homeViewModel.getHomeList(it)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                homeViewModel.homeFlow.collect { event ->
                    when (event) {
                        is HomeViewModel.Event.Loading -> {
                            progressBar.show()
                        }
                        is HomeViewModel.Event.Failure -> {
                            progressBar.dismiss()
                        }
                        is HomeViewModel.Event.Success -> {
                            progressBar.dismiss()
                            event.result?.let {
                                val categoryModel = it.categories
                                val advertisement = it.advertisments
                                setViewPager(advertisement)
                                categoryAdapter.differ.submitList(categoryModel)
                            }
                        }
                    }

                }
            }


//            viewPager.adapter = itemPagerAdapter

//            indicator.setupWithViewPager(viewPager)



//            categoryRecyclerView.adapter = categoryAdapter
//
//            flashSaleRecycler.adapter = flashSaleAdapter
//
//            megaSaleRecycler.adapter = flashSaleAdapter
//
//            gridRecycler.adapter = gridAdapter

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

    private fun FragmentHomeBinding.setViewPager(advertisement: List<Advertisment>?) {
        val itemPagerAdapter = advertisement?.let { it1 ->
            ItemPagerAdapter(
                it1
            )
        }
        viewPager.adapter = itemPagerAdapter

        indicator.setupWithViewPager(viewPager)

        if (advertisement != null) {
            sliderTimer(viewPager, advertisement)
        }
    }

    private fun sliderTimer(viewPager: ViewPager,advertisement: List<Advertisment>) {
        runnable = object : Runnable {
            override fun run() {
                if (viewPager.currentItem < advertisement.size - 1) {
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
