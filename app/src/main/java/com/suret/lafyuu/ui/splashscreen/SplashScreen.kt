package com.suret.lafyuu.ui.splashscreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suret.lafyuu.ChangeStatusBarColor
import com.suret.lafyuu.R
import com.suret.lafyuu.constants.Constants


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
            val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences(
                Constants.userData,
                Context.MODE_PRIVATE
            )
            val isLogged = sharedPreferences?.getBoolean(Constants.loginBoolean, false)
            if (isLogged == true) {
                view.findNavController().navigate(R.id.action_splashScreen_to_nestedFragment)
            } else {
                view.findNavController().navigate(R.id.action_splashScreen_to_loginFragment)
            }
        }
        Handler(Looper.getMainLooper()).postDelayed(r, 2000)

    }

}