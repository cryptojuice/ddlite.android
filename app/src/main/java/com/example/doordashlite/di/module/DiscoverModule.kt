package com.example.doordashlite.di.module

import androidx.lifecycle.ViewModel
import com.example.doordashlite.di.ViewModelKey
import com.example.doordashlite.discover.DiscoverActivity
import com.example.doordashlite.discover.DiscoverFragment
import com.example.doordashlite.discover.DiscoverViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DiscoverModule {

    @ContributesAndroidInjector
    abstract fun discoverActivity(): DiscoverActivity

    @ContributesAndroidInjector(modules = [ViewModuleBuilderModule::class])
    abstract fun discoverFragment(): DiscoverFragment

    @Binds
    @IntoMap
    @ViewModelKey(DiscoverViewModel::class)
    abstract fun bindViewModel(viewModel: DiscoverViewModel): ViewModel
}