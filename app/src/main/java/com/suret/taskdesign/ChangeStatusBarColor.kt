package com.suret.taskdesign

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

class ChangeStatusBarColor {

    companion object {
        fun changeStatusBarColorForDarkMode(
            requireActivity: FragmentActivity,
            requireContext: Context,
            color: Int
        ) {
            val window: Window = requireActivity.window
            when (requireContext.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = ContextCompat.getColor(requireContext, color)
                }

            }
        }

        fun changeStatusBarColorForDayMode(
            requireActivity: FragmentActivity,
            requireContext: Context,
            color: Int
        ) {
            val window: Window = requireActivity.window
            when (requireContext.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_NO -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = ContextCompat.getColor(requireContext, color)
                    val decorView = window.decorView
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        val wic = decorView.windowInsetsController
                        wic!!.setSystemBarsAppearance(
                            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                        )
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

                    }
                }
            }
        }
    }
}