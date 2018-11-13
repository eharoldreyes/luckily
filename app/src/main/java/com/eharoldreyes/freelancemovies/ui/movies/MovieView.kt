package com.eharoldreyes.freelancemovies.ui.movies

import android.support.annotation.StringRes
import com.eharoldreyes.freelancemovies.base.BaseView
import com.eharoldreyes.freelancemovies.model.Movie

interface MovieView : BaseView {

    fun updateMovies(movies: List<Movie>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}