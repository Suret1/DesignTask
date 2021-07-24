package com.suret.lafyuu.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.suret.lafyuu.R
import com.suret.lafyuu.databinding.ActivityMainBinding
import com.suret.lafyuu.util.Constants
import com.suret.lafyuu.util.Constants.SETTINGS_PREF
import com.suret.lafyuu.util.PreferenceHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

}