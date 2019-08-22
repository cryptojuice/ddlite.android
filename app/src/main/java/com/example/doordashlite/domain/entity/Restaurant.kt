package com.example.doordashlite.domain.entity

import com.google.gson.annotations.SerializedName

data class Restaurant(
    val name: String,
    val description: String,
    val status: String,
    @SerializedName("delivery_fee") val deliveryFee: Double,
    val menus: List<Menu>? = null
    )

data class Menu(
    @SerializedName("popular_items") val popularItems: List<PopularItem>? = null
)

data class PopularItem(
    val img_url: String
)