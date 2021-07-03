package com.suret.lafyuu

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.content.ContextCompat

class ChangeStatusBarColor {

    companion object {
        fun changeStatusBarColorForMode(
            activity: Activity,
            requireContext: Context,
            darkModeColor: Int,
            dayModeColor: Int
        ) {
            val window: Window = activity.window
            when (requireContext.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = ContextCompat.getColor(requireContext, darkModeColor)
                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = ContextCompat.getColor(requireContext, dayModeColor)
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