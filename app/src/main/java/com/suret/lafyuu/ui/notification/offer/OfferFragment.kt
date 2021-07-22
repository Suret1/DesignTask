package com.suret.lafyuu.ui.notification.offer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.lafyuu.R
import com.suret.lafyuu.ui.adapter.OfferNotificationAdapter
import com.suret.lafyuu.databinding.FragmentOfferBinding
import com.suret.lafyuu.listmaker.OfferNotificationListMaker
import com.suret.lafyuu.data.model.test.NotificationOfferModel

class OfferFragment : Fragment() {
    private lateinit var offerBinding: FragmentOfferBinding
    private var offerList: MutableList<NotificationOfferModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        offerBinding = FragmentOfferBinding.inflate(inflater, container, false)
        return offerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        offerList = OfferNotificationListMaker.offerListMaker()

        val offerAdapter = OfferNotificationAdapter(offerList)

        offerBinding.offerRecycler.adapter = offerAdapter

        offerBinding.offerToolbar.setNavigationIcon(R.drawable.back_btn)

        offerBinding.offerToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }


    }

}