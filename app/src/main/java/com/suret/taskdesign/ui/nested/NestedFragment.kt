package com.suret.taskdesign.ui.nested

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import kotlinx.android.synthetic.main.fragment_nested.*


class NestedFragment : Fragment(R.layout.fragment_nested) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            ChangeStatusBarColor.changeStatusBarColorForMode(
                activity = it,
                requireContext = it,
                R.color.status_bar_night,
                R.color.white
            )
        }

        navController =
            Navigation.findNavController(requireActivity(), R.id.fragment_nested_container)

        bottom_nav.setupWithNavController(navController)

        bottom_nav.setOnNavigationItemReselectedListener {
            //empty
        }



        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.categoryFragment, R.id.superFlashSaleFragment, R.id.favorite, R.id.favorite -> hideBottomNavAndActionBar()
                else -> showBottomNavAndActionBar()
            }
        }

        main_toolbar.setOnMenuItemClickListener { item ->
            val navigation =
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
            when (item?.itemId) {
                R.id.favorite -> navigation.navigate(R.id.action_nestedFragment_to_favoriteFragment)
                R.id.notification -> navigation.navigate(R.id.action_nestedFragment_to_notificationFragment)
            }
            false
        }


    }

    private fun hideBottomNavAndActionBar() {
        bottom_nav.visibility = View.GONE
        main_toolbar.visibility = View.GONE
    }

    private fun showBottomNavAndActionBar() {
        bottom_nav.visibility = View.VISIBLE
        main_toolbar.visibility = View.VISIBLE
    }
}


