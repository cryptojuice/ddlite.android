package com.example.doordashlite

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.doordashlite.di.component.DaggerApplicationComponent
import com.example.doordashlite.di.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class DDLiteApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingSupportFragmentInjector: DispatchingAndroidInjector<Fragment>

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

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingSupportFragmentInjector
    }


}