package com.suret.lafyuu.ui.notification.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.lafyuu.R
import com.suret.lafyuu.ui.adapter.FeedRecyclerAdapter
import com.suret.lafyuu.databinding.FragmentFeedBinding
import com.suret.lafyuu.listmaker.FeedListMaker
import com.suret.lafyuu.model.NotificationOfferModel

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