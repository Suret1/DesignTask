package com.suret.lafyuu.ui.nested

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.suret.lafyuu.R
import com.suret.lafyuu.databinding.FragmentNestedBinding
import com.suret.lafyuu.util.ChangeStatusBarColor
import com.suret.lafyuu.util.Utils


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

        Utils.hideKeyboard(requireActivity())

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


            nestedBinding.bottomNav.selectedItemId = R.id.home
            val userProfileUrl = "https://i.pinimg.com/originals/fd/1f/79/fd1f79bccedb91b28bebeaf2f84159f3.jpg"

            nestedBinding.bottomNav.loadImage(
                userProfileUrl, R.id.account, R.drawable.ic_launcher_foreground
            )

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


