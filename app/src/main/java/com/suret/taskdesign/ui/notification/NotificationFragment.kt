package com.suret.taskdesign.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.suret.taskdesign.R
import com.suret.taskdesign.adapter.NotificationRecyclerAdapter
import com.suret.taskdesign.databinding.FragmentNotificationBinding
import com.suret.taskdesign.listmaker.NotificationListMaker
import com.suret.taskdesign.model.NotificationModel

class NotificationFragment : Fragment(),
    NotificationRecyclerAdapter.OnItemClickListener {
    private lateinit var notificationBinding: FragmentNotificationBinding
    private var notificationItemList: MutableList<NotificationModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationBinding = FragmentNotificationBinding.inflate(inflater, container, false)
        return notificationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationItemList = NotificationListMaker.notificationItemMaker()

        val notificationAdapter = NotificationRecyclerAdapter(notificationItemList, this)


        notificationBinding.notificationRecyclerView.adapter = notificationAdapter


        notificationBinding.notificationToolbar.setNavigationIcon(R.drawable.back_btn)

        notificationBinding.notificationToolbar.setNavigationOnClickListener {
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