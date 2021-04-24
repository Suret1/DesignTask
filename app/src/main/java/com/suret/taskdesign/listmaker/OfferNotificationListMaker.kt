package com.suret.taskdesign.listmaker

import com.suret.taskdesign.R
import com.suret.taskdesign.model.NotificationOfferModel

class OfferNotificationListMaker {
    companion object {
        fun offerListMaker(): MutableList<NotificationOfferModel> {
            val offerList: MutableList<NotificationOfferModel> = arrayListOf()


            offerList.add(
                NotificationOfferModel(
                    R.drawable.offer,
                    "The Best Title",
                    "Culpa cillum consectetur labore nulla nulla magna irure. Id veniam culpa officia aute dolor amet deserunt ex proident commodo",
                    "April 24, 2021 10:30 PM"

                )
            )
            offerList.add(
                NotificationOfferModel(
                    R.drawable.offer,
                    "SUMMER OFFER 98% Cashback",
                    "Culpa cillum consectetur labore nulla nulla magna irure. Id veniam culpa officia aute dolor",
                    "April 24, 2021 10:32 PM"

                )
            )
            offerList.add(
                NotificationOfferModel(
                    R.drawable.offer,
                    "Special Offer 25% OFF",
                    "Culpa cillum consectetur labore nulla nulla magna irure. Id veniam culpa officia aute dolor amet deserunt ex proident commodo",
                    "April 24, 2021 12:30 PM"

                )
            )

            return offerList

        }


    }
}