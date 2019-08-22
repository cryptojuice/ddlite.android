package com.example.doordashlite.di.module

import com.example.doordashlite.domain.RestaurantInteractor
import com.example.doordashlite.domain.RestaurantInteractorImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InteractorModule {
    @Binds
    abstract fun providesRestaurantInteractor(restaurantInteractor: RestaurantInteractorImpl): RestaurantInteractor
}