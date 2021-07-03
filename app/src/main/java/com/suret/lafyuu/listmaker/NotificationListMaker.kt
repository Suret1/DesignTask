package com.suret.lafyuu.listmaker

import com.suret.lafyuu.R
import com.suret.lafyuu.model.NotificationModel

class NotificationListMaker {
    companion object {

        fun notificationItemMaker(): MutableList<NotificationModel> {
            val notificationList: MutableList<NotificationModel> = arrayListOf()
            notificationList.add(
                NotificationModel(
                    R.drawable.offer,
                    R.string.offer,
                    "3"
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