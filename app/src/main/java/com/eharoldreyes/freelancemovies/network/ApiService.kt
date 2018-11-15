package com.eharoldreyes.freelancemovies.network

import com.eharoldreyes.freelancemovies.model.Movie
import com.eharoldreyes.freelancemovies.model.dto.ListResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface ApiService {

    /**
     * Get the list of the movies from the API
     */
    @GET("trending/all/day")
    fun getTrendingMovies(): Observable<ListResponse<Movie>>
}