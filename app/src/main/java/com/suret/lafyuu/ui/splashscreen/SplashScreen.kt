package com.suret.lafyuu.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suret.lafyuu.R
import com.suret.lafyuu.util.ChangeStatusBarColor


class SplashScreen : Fragment(R.layout.fragment_splash_screen) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.blue,
            R.color.blue
        )

        val r = Runnable {
            view.findNavController().navigate(R.id.action_splashScreen_to_loginFragment)
        }
        Handler(Looper.getMainLooper()).postDelayed(r, 1)

    }

}