package com.suret.taskdesign.listmaker

import com.suret.taskdesign.R
import com.suret.taskdesign.model.NotificationOfferModel

class FeedListMaker {
    companion object {
        fun feedListMaker(): MutableList<NotificationOfferModel> {
            val feedList: MutableList<NotificationOfferModel> = arrayListOf()

            feedList.add(
                NotificationOfferModel(
                    R.drawable.nike,
                    "New Product",
                    "Nike Air Zoom Pegasus 36 Miami - Special For your Activity",
                    "May 29, 2016 5:06 PM"
                )
            )
            feedList.add(
                NotificationOfferModel(
                    R.drawable.nike2,
                    "Best Product",
                    "Nike Air Zoom Pegasus 36 Miami - Special For your Activity",
                    "May 29, 2016 5:06 PM"
                )
            )
            feedList.add(
                NotificationOfferModel(
                    R.drawable.nike3,
                    "New Product",
                    "Nike Air Zoom Pegasus 36 Miami - Special For your Activity",
                    "May 29, 2016 5:06 PM"
                )
            )
            return feedList

        }


    }

}