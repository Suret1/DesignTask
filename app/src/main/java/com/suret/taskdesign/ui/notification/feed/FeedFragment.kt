package com.suret.taskdesign.ui.notification.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.FeedRecyclerAdapter
import com.suret.taskdesign.databinding.FragmentFeedBinding
import com.suret.taskdesign.listmaker.FeedListMaker
import com.suret.taskdesign.model.NotificationOfferModel

class FeedFragment : Fragment() {
    private lateinit var feedBinding: FragmentFeedBinding
    private var feedList: MutableList<NotificationOfferModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        feedBinding = FragmentFeedBinding.inflate(inflater, container, false)
        return feedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        feedList = FeedListMaker.feedListMaker()

        val feedAdapter = FeedRecyclerAdapter(feedList)

        feedBinding.feedRecycler.adapter = feedAdapter

        feedBinding.feedToolbar.setNavigationIcon(R.drawable.back_btn)

        feedBinding.feedToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

    }
}