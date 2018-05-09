package com.rrawlinson.newsstack.di.providers

import com.rrawlinson.newsstack.ui.HeadlinesFragment
import com.rrawlinson.newsstack.di.modules.HeadlinesFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(HeadlinesFragmentModule::class)])
    abstract fun provideHeadlinesFragmentFactory(): HeadlinesFragment
}