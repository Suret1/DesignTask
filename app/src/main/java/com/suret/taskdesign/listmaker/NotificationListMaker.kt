package com.suret.taskdesign.listmaker

import com.suret.taskdesign.R
import com.suret.taskdesign.model.NotificationModel

class NotificationListMaker {
    companion object {

        fun notificationItemMaker(): MutableList<NotificationModel> {
            val notificationList: MutableList<NotificationModel> = arrayListOf()
            notificationList.add(
                NotificationModel(
                    R.drawable.offer,
                    R.string.offer,
                    "2"
                )
            )
            notificationList.add(
                NotificationModel(
                    R.drawable.feed,
                    R.string.feed,
                    "4"
                )
            )
            notificationList.add(
                NotificationModel(
                    R.drawable.notification_blue,
                    R.string.activity,
                    "5"
                )
            )
            return notificationList
        }
    }

}