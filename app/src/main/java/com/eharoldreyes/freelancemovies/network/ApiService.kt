package com.eharoldreyes.freelancemovies.network

import com.eharoldreyes.freelancemovies.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("/movies")
    fun getMovies(): Observable<List<Movie>>
}