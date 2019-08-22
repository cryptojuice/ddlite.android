package com.example.doordashlite.domain

import com.example.doordashlite.domain.entity.Restaurant
import com.example.doordashlite.network.DoorDashAPIRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantInteractorImpl @Inject constructor(private val doorDashAPIRepository: DoorDashAPIRepository) : RestaurantInteractor {

    override fun getRestaurants(lat: String, lng: String, offset: Int, limit: Int): Observable<List<Restaurant>> {
        return doorDashAPIRepository.fetchRestaurants(lat, lng, offset, limit)
            .observeOn(Schedulers.io())
    }
}