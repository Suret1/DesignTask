package com.suret.lafyuu.data.model

import androidx.annotation.Keep

@Keep
data class HomeModel(
    val advertisments: List<Advertisment>? = null,
    val categories: List<Category>? = null,
    val items: List<Item>? = null
)
@Keep
data class Advertisment(
    val advertismentId: Int? = null,
    val date: String? = null,
    val image: String? = null,
    val title: String? = null
)
@Keep
data class Category(
    val categoryId: Int? = null,
    val icon: String? = null,
    val title: String? = null
)
@Keep
data class Item(
    val advertismentId: Int? = null,
    val products: List<Product>? = null,
    val title: String? = null
)
@Keep
data class Product(
    val discountPercent: Int? = null,
    val discountPrice: Double? = null,
    val images: List<String>? = null,
    val price: Double? = null,
    val productId: Int? = null,
    val rating: Double? = null,
    val specification: String? = null,
    val thumbnailImage: String? = null,
    val title: String? = null
)