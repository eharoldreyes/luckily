package com.eharoldreyes.freelancemovies.network

import com.eharoldreyes.freelancemovies.model.Movie
import com.eharoldreyes.freelancemovies.model.dto.ListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("trending/all/day")
    fun getTrendingMovies(): Observable<ListResponse<Movie>>
}