package com.example.doordashlite.di.component

import com.example.doordashlite.DDLiteApplication
import com.example.doordashlite.di.module.*
import com.example.doordashlite.di.module.InteractorModule
import dagger.Component
import dagger.MembersInjector
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    ViewModuleBuilderModule::class,
    DiscoverModule::class,
    InteractorModule::class,
    RepositoryModule::class,
    RxModule::class
])
internal interface ApplicationComponent : MembersInjector<DDLiteApplication>