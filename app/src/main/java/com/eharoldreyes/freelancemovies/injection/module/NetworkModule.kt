package com.eharoldreyes.freelancemovies.injection.module

import com.eharoldreyes.freelancemovies.BuildConfig
import com.eharoldreyes.freelancemovies.network.ApiService
import com.eharoldreyes.freelancemovies.network.SelfSignedOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about Context
 */
@Module
@Suppress("unused")
object NetworkModule {

    /**
     * Provides the API service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the API service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(SelfSignedOkHttpClient.create())
            .build()
    }
}