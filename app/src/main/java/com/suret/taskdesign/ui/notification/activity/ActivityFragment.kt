package com.suret.taskdesign.ui.notification.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.OfferNotificationAdapter
import com.suret.taskdesign.listmaker.ActivityListMaker
import com.suret.taskdesign.model.NotificationOfferModel
import kotlinx.android.synthetic.main.fragment_activity.*


class ActivityFragment : Fragment(R.layout.fragment_activity) {
    private var activityList: MutableList<NotificationOfferModel> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityList = ActivityListMaker.activityListMake()

        val activityAdapter = OfferNotificationAdapter(activityList)

        feed_recycler.adapter = activityAdapter

        feed_toolbar.setNavigationIcon(R.drawable.back_btn)

        feed_toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

    }
}