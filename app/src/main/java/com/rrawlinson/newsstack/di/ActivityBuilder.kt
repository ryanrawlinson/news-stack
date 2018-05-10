package com.rrawlinson.newsstack.di

import com.rrawlinson.newsstack.view.MainActivity
import com.rrawlinson.newsstack.di.modules.MainActivityModule
import com.rrawlinson.newsstack.di.providers.FragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (FragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}