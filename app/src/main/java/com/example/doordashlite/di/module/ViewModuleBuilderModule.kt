package com.example.doordashlite.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.doordashlite.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModuleBuilderModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}