package com.example.doordashlite.domain

import com.example.doordashlite.domain.entity.Restaurant
import io.reactivex.Observable

interface RestaurantInteractor {
    fun getRestaurants(): Observable<List<Restaurant>>
}