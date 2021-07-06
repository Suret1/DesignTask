package com.suret.lafyuu.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.lafyuu.databinding.FragmentAccountBinding


class AccountFragment : Fragment() {
    private lateinit var accountBinding: FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        accountBinding = FragmentAccountBinding.inflate(inflater, container, false)
        return accountBinding.root
    }
}