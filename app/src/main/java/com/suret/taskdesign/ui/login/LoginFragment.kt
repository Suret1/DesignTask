package com.suret.taskdesign.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.suret.taskdesign.ChangeStatusBarColor
import com.suret.taskdesign.R
import com.suret.taskdesign.constants.Constants
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.status_bar_night,
            R.color.white
        )

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
            view.findNavController().navigate(R.id.action_login_to_nested_nav_graph)
            requireActivity().finish()
        }


    }


}