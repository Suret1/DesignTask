package com.suret.taskdesign.listmaker

import com.suret.taskdesign.model.SalesModel

class SalesModelListMaker {

    companion object {
        fun salesListMaker(): MutableList<SalesModel> {
            val salesList: MutableList<SalesModel> = arrayListOf()
            salesList.add(
                SalesModel(
                    "https://cutt.ly/Ec49wPk",
                    "Nike Sale",
                    9607780
                )
            )
            salesList.add(
                SalesModel(
                    "https://cutt.ly/dc49tUC",
                    "Air Max Sale",
                    9685485
                )
            )
            salesList.add(
                SalesModel(
                    "https://cutt.ly/cvla8bP",
                    "Adidas Sale",
                    12854561
                )
            )
            return salesList
        }

    }
}