package com.eharoldreyes.freelancemovies.ui.movies

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.eharoldreyes.freelancemovies.R
import com.eharoldreyes.freelancemovies.base.BaseActivity
import com.eharoldreyes.freelancemovies.model.Movie
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity<MoviePresenter>(), MovieView {

    private val moviesAdapter = MovieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        movieList.adapter = moviesAdapter
        movieList.layoutManager = GridLayoutManager(this, 2)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateMovies(movies: List<Movie>) {
        moviesAdapter.updateMovies(movies)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun instantiatePresenter(): MoviePresenter {
        return MoviePresenter(this)
    }
}