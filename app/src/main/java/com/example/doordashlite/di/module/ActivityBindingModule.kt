package com.example.doordashlite.di.module

import com.example.doordashlite.DiscoverActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun discoverActivity(): DiscoverActivity
}