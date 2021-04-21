package com.suret.taskdesign.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
        setSupportActionBar(main_toolbar)
        main_toolbar.showOverflowMenu()
        main_toolbar.inflateMenu(R.menu.app_bar_menu)
        main_toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
        ChangeStatusBarColor.changeStatusBarColorForMode(
            activity = this,
            requireContext = applicationContext,
            R.color.status_bar_night,
            R.color.white
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.categoryFragment, R.id.superFlashSaleFragment, R.id.favorite -> hideBottomNavAndActionBar()
                else -> showBottomNavAndActionBar()
            }
        }
    }

    private fun hideBottomNavAndActionBar() {
        bottom_nav.visibility = View.GONE
        supportActionBar?.hide()
    }

    private fun showBottomNavAndActionBar() {
        bottom_nav.visibility = View.VISIBLE
        supportActionBar?.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> findNavController(R.id.fragment_nested_container).navigate(R.id.favorite)
            R.id.notification -> Log.d("dumb", "dumb")
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return super.onPrepareOptionsMenu(menu)
    }


}