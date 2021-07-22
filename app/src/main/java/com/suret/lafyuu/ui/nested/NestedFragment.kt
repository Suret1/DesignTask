package com.suret.lafyuu.ui.nested

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.suret.lafyuu.util.ChangeStatusBarColor
import com.suret.lafyuu.R
import com.suret.lafyuu.databinding.FragmentNestedBinding


class NestedFragment : Fragment() {
    private lateinit var nestedBinding: FragmentNestedBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nestedBinding = FragmentNestedBinding.inflate(inflater, container, false)
        return nestedBinding.root
    }

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

        nestedBinding.apply {
            bottomNav.setupWithNavController(navController)

            bottomNav.setOnNavigationItemReselectedListener {
                //empty
            }

            mainToolbar.setOnMenuItemClickListener { item ->
                val navigation =
                    Navigation.findNavController(requireActivity(), R.id.fragment_container)
                when (item?.itemId) {
                    R.id.favorite -> navigation.navigate(R.id.action_nestedFragment_to_favoriteFragment)
                    R.id.notification -> navigation.navigate(R.id.action_nestedFragment_to_notificationFragment)
                }
                false
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.categoryFragment, R.id.superFlashSaleFragment, R.id.favorite -> hideBottomNavAndActionBar()
                R.id.account, R.id.offer -> hideActionBar()
                else -> showBottomNavAndActionBar()
            }
        }
    }

    private fun hideBottomNavAndActionBar() {
        nestedBinding.bottomNav.visibility = View.GONE
        nestedBinding.mainToolbar.visibility = View.GONE
    }

    private fun hideActionBar() {
        nestedBinding.mainToolbar.visibility = View.GONE
    }

    private fun showBottomNavAndActionBar() {
        nestedBinding.bottomNav.visibility = View.VISIBLE
        nestedBinding.mainToolbar.visibility = View.VISIBLE
    }
}


