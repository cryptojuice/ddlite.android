package com.example.doordashlite.di.module

import com.example.doordashlite.network.DoorDashAPIRepository
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RepositoryModule {

    @Provides
    fun providesDoorDashAPIRepository(): DoorDashAPIRepository {
        return Retrofit.Builder()
            .baseUrl("https://api.doordash.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DoorDashAPIRepository::class.java)
    }
}