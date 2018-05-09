package com.rrawlinson.newsstack.di

import com.rrawlinson.newsstack.NewsStackApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent : AndroidInjector<NewsStackApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NewsStackApp>()
}
