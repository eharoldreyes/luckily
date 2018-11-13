package com.eharoldreyes.freelancemovies.ui.movies

import android.support.annotation.StringRes
import com.eharoldreyes.freelancemovies.base.BaseView
import com.eharoldreyes.freelancemovies.model.Movie

/**
 * Interface providing required method for a view displaying posts
 */
interface MovieView : BaseView {
    /**
     * Updates the previous posts by the specified ones
     * @param posts the list of posts that will replace existing ones
     */
    fun updatePosts(movies: List<Movie>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}