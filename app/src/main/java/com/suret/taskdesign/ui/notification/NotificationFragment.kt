package com.suret.taskdesign.ui.notification

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.NotificationRecyclerAdapter
import com.suret.taskdesign.listmaker.NotificationListMaker
import com.suret.taskdesign.model.NotificationModel
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : Fragment(R.layout.fragment_notification),
    NotificationRecyclerAdapter.OnItemClickListener {
    private var notificationItemList: MutableList<NotificationModel> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationItemList = NotificationListMaker.notificationItemMaker()

        val notificationAdapter = NotificationRecyclerAdapter(notificationItemList, this)


        notification_recycler_view.adapter = notificationAdapter


        notification_toolbar.setNavigationIcon(R.drawable.back_btn)

        notification_toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }


    }

    override fun onItemClick(position: Int) {
        val navigation = Navigation.findNavController(requireActivity(), R.id.fragment_container)
        when (position) {
            0 -> navigation.navigate(R.id.action_notification_to_offerFragment)
            1 -> navigation.navigate(R.id.action_notification_to_feedFragment)
            2 -> navigation.navigate(R.id.action_notification_to_activityFragment)
        }
    }

}