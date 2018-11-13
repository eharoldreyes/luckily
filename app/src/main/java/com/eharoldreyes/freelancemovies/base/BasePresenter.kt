package com.eharoldreyes.freelancemovies.base

import com.eharoldreyes.freelancemovies.injection.component.DaggerPresenterInjector
import com.eharoldreyes.freelancemovies.injection.module.ContextModule
import com.eharoldreyes.freelancemovies.injection.module.NetworkModule
import com.eharoldreyes.freelancemovies.ui.movies.MoviePresenter
import com.eharoldreyes.freelancemovies.injection.component.PresenterInjector

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when (this) {
            is MoviePresenter -> injector.inject(this)
        }
    }
}