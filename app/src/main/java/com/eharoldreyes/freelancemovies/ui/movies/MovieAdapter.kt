package com.eharoldreyes.freelancemovies.ui.movies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.eharoldreyes.freelancemovies.R
import com.eharoldreyes.freelancemovies.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Adapter for the list of the movies
 * @property context Context in which the application is running
 */
class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    /**
     * The list of movies of the adapter
     */
    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(context, LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    /**
     * Updates the list of movies of the adapter
     * @param movies the new list of posts of the adapter
     */
    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(private val context: Context, private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) {
            view.title.text = movie.title
            view.body.text = movie.vote_count.toString()
            val posterURI = "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + movie.poster_path
            Glide.with(context)
                .load(posterURI)
                .into(view.poster)
        }
    }
}