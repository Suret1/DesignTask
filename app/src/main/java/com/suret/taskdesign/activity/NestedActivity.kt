package com.suret.taskdesign.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import kotlinx.android.synthetic.main.activity_nested.*


class NestedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        val navController = findNavController(R.id.fragment_nested_container)

        bottom_nav.setupWithNavController(navController)
        bottom_nav.setOnNavigationItemReselectedListener {
            //empty
        }

        ChangeStatusBarColor.changeStatusBarColorForMode(
            activity = this,
            requireContext = applicationContext,
            R.color.status_bar_night,
            R.color.white
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.categoryFragment, R.id.superFlashSaleFragment, R.id.favorite -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun hideBottomNav() {
        bottom_nav.visibility = View.GONE
    }

    private fun showBottomNav() {
        bottom_nav.visibility = View.VISIBLE
    }

}