package com.eharoldreyes.freelancemovies.ui.movies

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.eharoldreyes.freelancemovies.R
import com.eharoldreyes.freelancemovies.base.BaseActivity
import com.eharoldreyes.freelancemovies.databinding.ActivityMovieBinding
import com.eharoldreyes.freelancemovies.model.Movie
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity<MoviePresenter>(), MovieView {

    private lateinit var binding: ActivityMovieBinding

    private val moviesAdapter = MovieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        movies_list.adapter = moviesAdapter
        movies_list.layoutManager = LinearLayoutManager(this)
        movies_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

//        binding.adapter = moviesAdapter
//        binding.layoutManager = LinearLayoutManager(this)
//        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

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
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): MoviePresenter {
        return MoviePresenter(this)
    }
}