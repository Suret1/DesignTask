package com.suret.lafyuu.ui.offer

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.suret.lafyuu.databinding.FragmentOffer2Binding


class OfferFragment : Fragment() {
    private lateinit var offerBinding: FragmentOffer2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        offerBinding = FragmentOffer2Binding.inflate(inflater, container, false)
        return offerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        offerBinding.apply {
            salesImageView.load("https://cutt.ly/Ec49wPk")
            iwMegaSale.load("https://cutt.ly/dc49tUC")

            object : CountDownTimer(12854561, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    hourTv.text = (millisUntilFinished / (1000 * 60 * 60) % 24).toString()
                    minuteTv.text = ((millisUntilFinished / (1000 * 60)) % 60).toString()
                    secondTv.text = (millisUntilFinished / 1000 % 60).toString()
                }

                override fun onFinish() {
                    //
                }
            }.start()
        }


    }

}