package com.suret.taskdesign.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        sign_tv.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}