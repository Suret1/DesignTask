package com.suret.lafyuu.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.lafyuu.databinding.FragmentAccountBinding
import com.suret.lafyuu.util.Constants
import com.suret.lafyuu.util.Constants.SETTINGS_PREF
import com.suret.lafyuu.util.Constants.USER_FULL_NAME
import com.suret.lafyuu.util.PreferenceHelper


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = PreferenceHelper.customPrefs(requireContext(), SETTINGS_PREF).getString(
            USER_FULL_NAME,"")
        accountBinding.apply {
            tvProfileName.text = name
        }
    }
}