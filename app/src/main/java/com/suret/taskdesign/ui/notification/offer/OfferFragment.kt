package com.suret.taskdesign.ui.notification.offer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.OfferNotificationAdapter
import com.suret.taskdesign.listmaker.OfferNotificationListMaker
import com.suret.taskdesign.model.NotificationOfferModel
import kotlinx.android.synthetic.main.fragment_offer.*

class OfferFragment : Fragment(R.layout.fragment_offer) {
    private var offerList: MutableList<NotificationOfferModel> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        offerList = OfferNotificationListMaker.offerListMaker()

        val offerAdapter = OfferNotificationAdapter(offerList)

        feed_recycler.adapter = offerAdapter

        feed_toolbar.setNavigationIcon(R.drawable.back_btn)

        feed_toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }



    }

}