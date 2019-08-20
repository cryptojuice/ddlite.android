package com.example.doordashlite

import android.app.Activity
import android.app.Application
import com.example.doordashlite.di.component.DaggerApplicationComponent
import com.example.doordashlite.di.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DDLiteApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        val component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        component.injectMembers(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}