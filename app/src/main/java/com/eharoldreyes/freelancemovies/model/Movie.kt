package com.eharoldreyes.freelancemovies.model

data class Movie(
    val id: Int,
    val title: String?,
    val poster_path: String?,
    val backdrop_path: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String? = null,
    val popularity: Float,
    val vote_average: Float,
    val vote_count: Float
)