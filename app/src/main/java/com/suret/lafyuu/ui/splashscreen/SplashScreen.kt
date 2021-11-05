package com.suret.lafyuu.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suret.lafyuu.R
import com.suret.lafyuu.util.ChangeStatusBarColor
import com.suret.lafyuu.util.Constants.SETTINGS_PREF
import com.suret.lafyuu.util.Constants.TOKEN
import com.suret.lafyuu.util.PreferenceHelper


class SplashScreen : Fragment(R.layout.fragment_splash_screen) {
    private var token: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.blue,
            R.color.blue
        )
//        token = PreferenceHelper.customPrefs(requireContext(), SETTINGS_PREF)
//            .getString(TOKEN, "")
//        val r = Runnable {
//            if (token.isNullOrEmpty()) {
//                view.findNavController().navigate(R.id.action_splashScreen_to_loginFragment)
//            } else {
                view.findNavController().navigate(R.id.action_splashScreen_to_nestedFragment)
//            }
//        }
//        Handler(Looper.getMainLooper()).postDelayed(r, 1)

    }

}