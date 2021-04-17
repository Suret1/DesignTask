package com.suret.taskdesign.model

import com.suret.taskdesign.R

class CategoryModelListMaker {
    companion object {
        fun categoryListMaker(): MutableList<CategoryModel> {
            val categoryModelList: MutableList<CategoryModel> = arrayListOf()

            categoryModelList.add(
                CategoryModel(
                    R.drawable.man_shirt,
                    R.string.man_shirt
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.dress,
                    R.string.dress
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.man_bag,
                    R.string.man_bag
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.woman_bag,
                    R.string.woman_bag
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.man_shoes,
                    R.string.man_shoes
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.woman_pants,
                    R.string.woman_pants
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.skirt,
                    R.string.skirt
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.man_pants,
                    R.string.man_pants
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.high_heels,
                    R.string.high_heels
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.man_tshirt,
                    R.string.man_t_shirt
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.woman_tshirt,
                    R.string.woman_t_shirt
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.man_underwear,
                    R.string.man_underwear
                )
            )
            categoryModelList.add(
                CategoryModel(
                    R.drawable.bikini,
                    R.string.bikini
                )
            )
            return categoryModelList
        }

    }
}