package com.rrawlinson.newsstack.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(Interceptor {
                    val url = it.request().url()
                            .newBuilder()
                            .addQueryParameter("apiKey", "36641f142d97430db107726d6deb5f06")
                            .build()

                    val request = it.request().newBuilder().url(url).build()
                    it.proceed(request)
                }).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}