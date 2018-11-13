package com.eharoldreyes.freelancemovies.ui.movies

import com.eharoldreyes.freelancemovies.R
import com.eharoldreyes.freelancemovies.base.BasePresenter
import com.eharoldreyes.freelancemovies.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviePresenter(movieView: MovieView) : BasePresenter<MovieView>(movieView) {

    @Inject
    lateinit var apiService: ApiService

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadMovies()
    }

    private fun loadMovies() {
        view.showLoading()
        subscription = apiService
            .getMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { postList -> view.updateMovies(postList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}