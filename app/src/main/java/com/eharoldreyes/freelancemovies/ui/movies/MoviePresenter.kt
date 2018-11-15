package com.eharoldreyes.freelancemovies.ui.movies

import com.eharoldreyes.freelancemovies.R
import com.eharoldreyes.freelancemovies.base.BasePresenter
import com.eharoldreyes.freelancemovies.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * The Presenter that will present the Movie view.
 * @param movieView the Movie view to be presented by the presenter
 * @property apiService the API interface implementation
 * @property subscription the subscription to the API call
 */
class MoviePresenter(movieView: MovieView) : BasePresenter<MovieView>(movieView) {

    @Inject
    lateinit var apiService: ApiService

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadMovies()
    }

    /**
     * Loads the movie from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    private fun loadMovies() {
        view.showLoading()
        subscription = apiService.getTrendingMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                {
                    view.updateMovies(it.results)
                },
                {
                    view.showError(R.string.unknown_error)
                }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}