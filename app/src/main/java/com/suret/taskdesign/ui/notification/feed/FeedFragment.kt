package com.suret.taskdesign.ui.notification.feed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.FeedRecyclerAdapter
import com.suret.taskdesign.adapter.OfferNotificationAdapter
import com.suret.taskdesign.listmaker.FeedListMaker
import com.suret.taskdesign.model.NotificationOfferModel
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private var feedList: MutableList<NotificationOfferModel> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        feedList = FeedListMaker.feedListMaker()

        val feedAdapter = FeedRecyclerAdapter(feedList)

        feed_recycler.adapter = feedAdapter

        feed_toolbar.setNavigationIcon(R.drawable.back_btn)

        feed_toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

    }
}