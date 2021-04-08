package com.suret.taskdesign.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suret.taskdesign.R
import com.suret.taskdesign.constants.Constants
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val window = requireActivity().window
        val decorView = window.decorView

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val wic = decorView.windowInsetsController
            wic!!.setSystemBarsAppearance(
                APPEARANCE_LIGHT_STATUS_BARS,
                APPEARANCE_LIGHT_STATUS_BARS
            )
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        }

        register_tv.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        sign_in_btn.setOnClickListener {

            val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences(
                Constants.userData,
                Context.MODE_PRIVATE
            )
            val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
            editor?.putBoolean(Constants.loginBoolean, true)
            editor?.apply()
            editor?.commit()
            Toast.makeText(requireActivity(),"Logged in", Toast.LENGTH_LONG).show()
            view.findNavController().navigate(R.id.action_loginFragment_to_testFragment)
        }


    }


}