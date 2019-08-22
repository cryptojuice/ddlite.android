package com.example.doordashlite.network

import com.example.doordashlite.domain.entity.Restaurant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DoorDashAPIRepository {

    @Headers("Content-Type: application/json")
    @GET("/v2/restaurant")
    fun fetchRestaurants(
        @Query("lat") lat: String,
        @Query("lng") lng: String,
        @Query("offset") offset: String,
        @Query("limit") limit: String): Observable<List<Restaurant>>
}