package com.example.doordashlite.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

@Module
class RxModule {

    @Provides
    fun providesSchduler(): Scheduler = Schedulers.io()
}