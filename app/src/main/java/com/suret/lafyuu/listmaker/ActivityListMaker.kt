package com.suret.lafyuu.listmaker

import com.suret.lafyuu.R
import com.suret.lafyuu.data.model.test.NotificationOfferModel

class ActivityListMaker {
    companion object {
        fun activityListMake(): MutableList<NotificationOfferModel> {
            val activityList: MutableList<NotificationOfferModel> = arrayListOf()

            activityList.add(
                NotificationOfferModel(
                    R.drawable.transaction,
                    "Transaction Nike Air Zoom Product",
                    "Culpa cillum consectetur labore nulla nulla magna irure. Id veniam culpa officia aute dolor amet deserunt ex proident commodo",
                    "May 29, 2016 5:06 PM"
                )
            )
            activityList.add(
                NotificationOfferModel(
                    R.drawable.transaction,
                    "Transaction Nike Air Zoom Pegasus 36 Miami",
                    "Culpa cillum consectetur labore nulla nulla magna irure. Id veniam culpa officia aute dolor",
                    "May 29, 2016 5:06 PM"
                )
            )
            activityList.add(
                NotificationOfferModel(
                    R.drawable.transaction,
                    "Transaction Nike Air Max",
                    "Culpa cillum consectetur labore nulla nulla magna irure. Id veniam culpa officia aute dolor amet deserunt ex proident commodo",
                    "May 29, 2016 5:06 PM"
                )
            )
            return activityList
        }
    }
}