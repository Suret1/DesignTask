package com.suret.taskdesign.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.ChangeStatusBarColor
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ChangeStatusBarColor.changeStatusBarColorForMode(
            requireActivity(),
            requireContext(),
            R.color.status_bar_night,
            R.color.white
        )

        sign_tv.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}