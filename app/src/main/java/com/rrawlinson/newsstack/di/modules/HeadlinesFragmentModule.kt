package com.rrawlinson.newsstack.di.modules

import com.rrawlinson.newsstack.domain.viewmodels.HeadlinesViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HeadlinesFragmentModule {

    @Provides
    @Singleton
    fun provideHeadlinesViewModel(): HeadlinesViewModel {
        return HeadlinesViewModel()
    }
}