package com.example.doordashlite.di.component

import com.example.doordashlite.DDLiteApplication
import com.example.doordashlite.di.module.ActivityBindingModule
import com.example.doordashlite.di.module.ApplicationModule
import dagger.Component
import dagger.MembersInjector
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    ActivityBindingModule::class])
internal interface ApplicationComponent : MembersInjector<DDLiteApplication>