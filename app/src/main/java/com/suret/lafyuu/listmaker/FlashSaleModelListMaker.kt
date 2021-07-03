package com.suret.lafyuu.listmaker

import com.suret.lafyuu.model.SuperFlashSaleModel

class FlashSaleModelListMaker {
    companion object {
        fun flashSaleListMaker(): MutableList<SuperFlashSaleModel> {
            val flashSaleList: MutableList<SuperFlashSaleModel> = arrayListOf()

            flashSaleList.add(
                SuperFlashSaleModel(
                    "https://cutt.ly/BvQeKJR",
                    "FS - Nike Air Max Reactive",
                    "$234.90"
                )
            )
            flashSaleList.add(
                SuperFlashSaleModel(
                    "https://cutt.ly/fvQrozB",
                    "Prada Galleria Saffiano leather bag",
                    "$349.99"
                )
            )
            flashSaleList.add(
                SuperFlashSaleModel(
                    "https://cutt.ly/gvQttzD",
                    "Pierre Cardin Plain Suit Jackets",
                    "$190.0"
                )
            )
            flashSaleList.add(
                SuperFlashSaleModel(
                    "https://cutt.ly/1vRzkxy",
                    "Stradivarius Contrast trainers",
                    "$52.0"
                )
            )
            flashSaleList.add(
                SuperFlashSaleModel(
                    "https://cutt.ly/xvRleCJ",
                    "Adidas ESSENTIALS 3-STRIPES HOODIE",
                    "$48.0"

                )
            )


            return flashSaleList

        }
    }
}