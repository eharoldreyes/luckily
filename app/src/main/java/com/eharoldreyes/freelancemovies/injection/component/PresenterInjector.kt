package com.eharoldreyes.freelancemovies.injection.component

import com.eharoldreyes.freelancemovies.base.BaseView
import dagger.BindsInstance
import dagger.Component
import com.eharoldreyes.freelancemovies.injection.module.ContextModule
import com.eharoldreyes.freelancemovies.injection.module.NetworkModule
import com.eharoldreyes.freelancemovies.ui.movies.MoviePresenter
import javax.inject.Singleton


@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(moviePresenter: MoviePresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}