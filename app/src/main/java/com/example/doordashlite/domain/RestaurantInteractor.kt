package com.example.doordashlite.domain

import com.example.doordashlite.domain.entity.Restaurant
import io.reactivex.Observable

interface RestaurantInteractor {
    fun getRestaurants(lat: String, lng: String, offset: Int = 0, limit: Int = 100): Observable<List<Restaurant>>
}