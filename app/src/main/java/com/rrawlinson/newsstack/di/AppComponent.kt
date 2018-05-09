package com.rrawlinson.newsstack.di

import com.rrawlinson.newsstack.NewsStackApp
import com.rrawlinson.newsstack.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (NetworkModule::class), (ActivityBuilder::class)])
interface AppComponent : AndroidInjector<NewsStackApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NewsStackApp>()
}
