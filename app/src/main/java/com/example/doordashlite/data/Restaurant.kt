package com.example.doordashlite.data

data class Restaurant(
    val name: String,
    val description: String,
    val status: String,
    val deliveryFee: Double,
    val menus: List<Menu>? = null
    )

data class Menu(
    val popularItems: List<PopularItem>? = null
)

data class PopularItem(
    val img_url: String
)