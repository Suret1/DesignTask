package com.suret.taskdesign.ui.notification.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.OfferNotificationAdapter
import com.suret.taskdesign.databinding.FragmentActivityBinding
import com.suret.taskdesign.listmaker.ActivityListMaker
import com.suret.taskdesign.model.NotificationOfferModel


class ActivityFragment : Fragment() {
    private lateinit var activityBinding: FragmentActivityBinding
    private var activityList: MutableList<NotificationOfferModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activityBinding = FragmentActivityBinding.inflate(inflater, container, false)
        return activityBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityList = ActivityListMaker.activityListMake()

        val activityAdapter = OfferNotificationAdapter(activityList)

        activityBinding.activityRecycler.adapter = activityAdapter

        activityBinding.activityToolbar.setNavigationIcon(R.drawable.back_btn)

        activityBinding.activityToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

    }
}